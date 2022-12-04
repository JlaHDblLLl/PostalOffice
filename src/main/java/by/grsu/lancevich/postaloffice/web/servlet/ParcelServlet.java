package by.grsu.lancevich.postaloffice.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.dao.impl.AddressDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.ParcelDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.PersonDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;
import by.grsu.lancevich.postaloffice.web.ValidationUtils;
import by.grsu.lancevich.postaloffice.web.dto.ParcelDto;
import by.grsu.lancevich.postaloffice.web.dto.TableStateDto;

public class ParcelServlet extends AbstractListServlet{
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doGet");
		String viewParam = req.getParameter("view");
		if ("edit".equals(viewParam)) {
			handleEditView(req, res);
		} else {
			handleListView(req, res);
		}
	}
	private void handleListView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int totalParcels = parcelDao.count();
		final TableStateDto tableStateDto = resolveTableStateDto(req, totalParcels); 
		List<Parcel> parcels = parcelDao.find(tableStateDto); 

		List<ParcelDto> dtos = parcels.stream().map((entity) -> {
			ParcelDto dto = new ParcelDto();
			dto.setId(entity.getId());
			dto.setDate_send(entity.getDate_send());
			dto.setDate_accept(entity.getDate_accept());
			dto.setFragile(entity.getFragile());
			dto.setWeight(entity.getWeight());
			dto.setLength(entity.getLength());
			dto.setWidth(entity.getWidth());
			dto.setHeight(entity.getHeight());
			dto.setExpiration_date(entity.getExpiration_date());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());

			Address address_from = addressDao.getById(entity.getAddress_from_id());
			Address address_to = addressDao.getById(entity.getAddress_to_id());

			dto.setAddress_from_name(address_from.getCountry() + " " + address_from.getStreet() + " " + address_from.getHouse());
			dto.setAddress_to_name(address_to.getCountry() + " " + address_to.getStreet() + " " + address_to.getHouse());

			Person sender = personDao.getById(entity.getSender_id());
			Person receiver = personDao.getById(entity.getReceiver_id());

			dto.setSender_name(sender.getName() + " " + sender.getSurname() + " " + sender.getPassport_number() + " " + sender.getPassport_authority());
			dto.setReceiver_name(receiver.getName() + " " + receiver.getSurname() + " " + receiver.getPassport_number() + " " + receiver.getPassport_authority());

			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("parcel-list.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String parcelIdStr = req.getParameter("id");

		if (!ValidationUtils.isInteger(parcelIdStr)) {
			res.sendError(400); // send HTTP status 400 and close response
			return;
		}

		ParcelDto dto = new ParcelDto();
		if (!Strings.isNullOrEmpty(parcelIdStr)) {
			Integer parcelId = Integer.parseInt(parcelIdStr);
			Parcel entity = parcelDao.getById(parcelId);
			dto.setId(entity.getId());
			dto.setDate_send(entity.getDate_send());
			dto.setDate_accept(entity.getDate_accept());
			dto.setFragile(entity.getFragile());
			dto.setLength(entity.getLength());
			dto.setWidth(entity.getWidth());
			dto.setWeight(entity.getWeight());
			dto.setHeight(entity.getHeight());
			dto.setExpiration_date(entity.getExpiration_date());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());
			dto.setAddress_from_id(entity.getAddress_from_id());
			dto.setAddress_to_id(entity.getAddress_to_id());
			dto.setSender_id(entity.getSender_id());
			dto.setReceiver_id(entity.getReceiver_id());
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allAddresses", getAllAddressesDtos());
		req.setAttribute("allPersons", getAllPersonsDtos());
		req.getRequestDispatcher("parcel-edit.jsp").forward(req, res);
	}
	
	private List<Address> getAllAddressesDtos() {
		return addressDao.getAll().stream().map((entity) -> {
			Address dto = new Address();
			dto.setId(entity.getId());
			dto.setStreet(entity.getStreet());
			dto.setHouse(entity.getHouse());
			return dto;
		}).collect(Collectors.toList());
	}
	private List<Person> getAllPersonsDtos() {
		return personDao.getAll().stream().map((entity) -> {
			Person dto = new Person();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setSurname(entity.getSurname());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Parcel parcel = new Parcel();
		String parcelIdStr = req.getParameter("id");
		String address_fromIdStr = req.getParameter("address_from_id");
		String address_toIdStr = req.getParameter("address_to_id");
		String senderIdStr = req.getParameter("sender_id");
		String receiverIdStr = req.getParameter("receiver_id");


		parcel.setDate_send(Timestamp.valueOf(req.getParameter("date_send")));
		parcel.setDate_accept(Timestamp.valueOf(req.getParameter("date_accept")));
		parcel.setFragile(Boolean.parseBoolean(req.getParameter("fragile")));
		parcel.setLength(Double.parseDouble(req.getParameter("length")));
		parcel.setWidth(Double.parseDouble(req.getParameter("width")));
		parcel.setWeight(Double.parseDouble(req.getParameter("weight")));
		parcel.setHeight(Double.parseDouble(req.getParameter("height")));
		parcel.setExpiration_date(Timestamp.valueOf(req.getParameter("expiration_date")));


		parcel.setAddress_from_id(address_fromIdStr == null ? null : Integer.parseInt(address_fromIdStr));
		parcel.setAddress_to_id(address_toIdStr == null ? null : Integer.parseInt(address_toIdStr));
		parcel.setSender_id(senderIdStr == null ? null : Integer.parseInt(senderIdStr));
		parcel.setReceiver_id(receiverIdStr == null ? null : Integer.parseInt(receiverIdStr));

		parcel.setUpdated(new Timestamp(new Date().getTime()));

		if (Strings.isNullOrEmpty(parcelIdStr)) {
			parcel.setCreated(new Timestamp(new Date().getTime()));
			parcelDao.insert(parcel);
		} else {
			parcel.setId(Integer.parseInt(parcelIdStr));
			parcelDao.update(parcel);
		}
		res.sendRedirect("/parcels");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		parcelDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}

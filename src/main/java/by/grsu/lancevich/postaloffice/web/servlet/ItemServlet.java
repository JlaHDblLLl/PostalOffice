package by.grsu.lancevich.postaloffice.web.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.dao.impl.ItemDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.ParcelDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.PersonDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Item;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;
import by.grsu.lancevich.postaloffice.web.ValidationUtils;
import by.grsu.lancevich.postaloffice.web.dto.ItemDto;
import by.grsu.lancevich.postaloffice.web.dto.ParcelDto;

public class ItemServlet extends HttpServlet{
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;

	private static final IDao<Integer, Item> itemDao = ItemDaoImpl.INSTANCE;

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
		List<Item> parcels = itemDao.getAll();

		List<ItemDto> dtos = parcels.stream().map((entity) -> {
			ItemDto dto = new ItemDto();
			dto.setId(entity.getId());
			dto.setFragile(entity.getFragile());
			dto.setWeight(entity.getWeight());
			dto.setLength(entity.getLength());
			dto.setWidth(entity.getWidth());
			dto.setHeight(entity.getHeight());
			dto.setExpiration_date(entity.getExpiration_date());

			Parcel parcel = parcelDao.getById(entity.getParcel_id());
			Person sender = personDao.getById(parcel.getSender_id());
			Person receiver = personDao.getById(parcel.getReceiver_id());

			dto.setParcel_name(sender.getName() + " " + receiver.getName() + " " + parcel.getDate_send() + " "+ parcel.getDate_accept());

			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("item-list.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String itemIdStr = req.getParameter("id");

		if (!ValidationUtils.isInteger(itemIdStr)) {
			res.sendError(400); // send HTTP status 400 and close response
			return;
		}
		
		ItemDto dto = new ItemDto();
		if (!Strings.isNullOrEmpty(itemIdStr)) {
			Integer parcelId = Integer.parseInt(itemIdStr);
			Item entity = itemDao.getById(parcelId);
			dto.setId(entity.getId());
			dto.setParcel_id(entity.getParcel_id());
			dto.setFragile(entity.getFragile());
			dto.setLength(entity.getLength());
			dto.setWidth(entity.getWidth());
			dto.setWeight(entity.getWeight());
			dto.setHeight(entity.getHeight());
			dto.setExpiration_date(entity.getExpiration_date());
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allParcels", getAllParcelsDtos());
		req.getRequestDispatcher("item-edit.jsp").forward(req, res);
	}
	
	private List<ParcelDto> getAllParcelsDtos() {
		return parcelDao.getAll().stream().map((entity) -> {
			ParcelDto dto = new ParcelDto();
			dto.setId(entity.getId());
			Person receiver = personDao.getById(entity.getReceiver_id());
			Person sender = personDao.getById(entity.getSender_id());
			dto.setReceiver_name(receiver.getName() +" "+ receiver.getSurname());
			dto.setSender_name(sender.getName() +" "+ sender.getSurname());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Item item = new Item();
		String itemIdStr = req.getParameter("id");
		String parcelIdStr = req.getParameter("parcel_id");


		item.setFragile(Boolean.parseBoolean(req.getParameter("fragile")));
		item.setLength(Double.parseDouble(req.getParameter("length")));
		item.setWidth(Double.parseDouble(req.getParameter("width")));
		item.setWeight(Double.parseDouble(req.getParameter("weight")));
		item.setHeight(Double.parseDouble(req.getParameter("height")));

		item.setExpiration_date(Timestamp.valueOf(req.getParameter("expiration_date")));


		item.setParcel_id(parcelIdStr == null ? null : Integer.parseInt(parcelIdStr));

		if (Strings.isNullOrEmpty(itemIdStr)) {
			itemDao.insert(item);
		} else {
			item.setId(Integer.parseInt(itemIdStr));
			itemDao.update(item);
		}
		res.sendRedirect("/items");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		itemDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}

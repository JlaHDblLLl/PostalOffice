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
import by.grsu.lancevich.postaloffice.db.dao.impl.PersonDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Person;
import by.grsu.lancevich.postaloffice.web.ValidationUtils;
import by.grsu.lancevich.postaloffice.web.dto.TableStateDto;
import by.grsu.lancevich.postaloffice.web.dto.UserdataDto;

public class PersonServlet extends AbstractListServlet {
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;

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
		int totalPersons = personDao.count();
		final TableStateDto tableStateDto = resolveTableStateDto(req, totalPersons); 
		List<Person> persons = personDao.find(tableStateDto); 

		List<UserdataDto> dtos = persons.stream().map((entity) -> {
			UserdataDto dto = new UserdataDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setSurname(entity.getSurname());
			dto.setPatronymic(entity.getPatronymic());
			dto.setPassport_number(entity.getPassport_number());
			dto.setIndetification_number(entity.getIndetification_number());
			dto.setPassport_authority(entity.getPassport_authority());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());

			Address address = addressDao.getById(entity.getAddress_id());
			dto.setAddress_name(address.getCountry() + " " + address.getStreet() + " " + address.getHouse());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("userData-list.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String personIdStr = req.getParameter("id");
		
		if (!ValidationUtils.isInteger(personIdStr)) {
			res.sendError(400); // send HTTP status 400 and close response
			return;
		}

		UserdataDto dto = new UserdataDto();
		if (!Strings.isNullOrEmpty(personIdStr)) {
			Integer personId = Integer.parseInt(personIdStr);
			Person entity = personDao.getById(personId);
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setSurname(entity.getSurname());
			dto.setPatronymic(entity.getPatronymic());
			dto.setPassport_number(entity.getPassport_number());
			dto.setIndetification_number(entity.getIndetification_number());
			dto.setPassport_authority(entity.getPassport_authority());
			dto.setCreated(entity.getCreated());
			dto.setUpdated(entity.getUpdated());
			dto.setAddress_id(entity.getAddress_id());
		}
		req.setAttribute("dto", dto);
		req.setAttribute("allAddresses", getAllAddressesDtos());
		req.getRequestDispatcher("userData-edit.jsp").forward(req, res);
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

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Person person = new Person();
		String personIdStr = req.getParameter("id");
		String addressIdStr = req.getParameter("address_id");

		person.setName(req.getParameter("name"));
		person.setSurname(req.getParameter("surname"));
		person.setPatronymic(req.getParameter("patronymic"));
		person.setPassport_number(req.getParameter("passport_number"));
		person.setIndetification_number(req.getParameter("indetification_number"));
		person.setPassport_authority(req.getParameter("passport_authority"));
		person.setUpdated(new Timestamp(new Date().getTime()));
		person.setAddress_id(addressIdStr == null ? null : Integer.parseInt(addressIdStr));

		if (Strings.isNullOrEmpty(personIdStr)) {
			person.setCreated(new Timestamp(new Date().getTime()));
			personDao.insert(person);
		} else {
			person.setId(Integer.parseInt(personIdStr));
			personDao.update(person);
		}
		res.sendRedirect("/userdata");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		personDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}
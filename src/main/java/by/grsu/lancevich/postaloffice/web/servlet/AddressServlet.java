package by.grsu.lancevich.postaloffice.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.base.Strings;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.dao.impl.AddressDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.web.ValidationUtils;

public class AddressServlet extends HttpServlet {
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;

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
		List<Address> addresses = addressDao.getAll();

		List<Address> dtos = addresses.stream().map((entity) -> {
			Address dto = new Address();
			dto.setId(entity.getId());
			dto.setCountry(entity.getCountry());
			dto.setTown(entity.getTown());
			dto.setStreet(entity.getStreet());
			dto.setHouse(entity.getHouse());
			dto.setFlat(entity.getFlat());
			return dto;
		}).collect(Collectors.toList());

		req.setAttribute("list", dtos);
		req.getRequestDispatcher("address-list.jsp").forward(req, res);
	}

	private void handleEditView(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String addressIdStr = req.getParameter("id");

		if (!ValidationUtils.isInteger(addressIdStr)) {
			res.sendError(400); // send HTTP status 400 and close response
			return;
		}

		Address dto = new Address();
		if (!Strings.isNullOrEmpty(addressIdStr)) {
			Integer addressId = Integer.parseInt(addressIdStr);
			Address entity = addressDao.getById(addressId);
			dto.setId(entity.getId());
			dto.setCountry(entity.getCountry());
			dto.setTown(entity.getTown());
			dto.setStreet(entity.getStreet());
			dto.setHouse(entity.getHouse());
			dto.setFlat(entity.getFlat());
		}
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("address-edit.jsp").forward(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doPost");
		Address address = new Address();
		String addressIdStr = req.getParameter("id");
		String paramCountry = req.getParameter("country");
		String paramTown = req.getParameter("town");
		String paramStreet = req.getParameter("street");
		String paramHouse = req.getParameter("house");
		String paramFlat = req.getParameter("flat");
		address.setCountry(paramCountry);
		address.setTown(paramTown);
		address.setStreet(paramStreet);
		address.setHouse(paramHouse);
		address.setFlat(paramFlat);

		if (Strings.isNullOrEmpty(addressIdStr)) {
			addressDao.insert(address);
		} else {
			address.setId(Integer.parseInt(addressIdStr));
			addressDao.update(address);
		}
		res.sendRedirect("/addresses");
	}

	@Override
	public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("doDelete");
		addressDao.delete(Integer.parseInt(req.getParameter("id")));
	}
}
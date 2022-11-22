package by.grsu.lancevich.postaloffice.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.dao.impl.AddressDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;

public class AddressServlet extends HttpServlet {
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Integer addressId = Integer.parseInt(req.getParameter("id")); // read request parameter
		Address addressById = addressDao.getById(addressId); // from DB

		res.setContentType("text/html");// setting the content type

		PrintWriter pw = res.getWriter();// get the stream to write the data

		// writing html in the stream
		pw.println("<html><body>");

		if (addressById == null) {
			pw.println("no brand by id=" + addressId);
		} else {
			pw.println(addressById.toString());
		}

		pw.println("</body></html>");
		pw.close();// closing the stream
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();// get the stream to write the data
		pw.println("<html><body>");
		try {
			String paramCountry = req.getParameter("country");
			String paramTown = req.getParameter("town");
			String paramStreet = req.getParameter("street");
			String paramHouse = req.getParameter("house");
			String paramFlat = req.getParameter("flat");
			Address addressEntity = new Address();
			addressEntity.setCountry(paramCountry);
			addressEntity.setTown(paramTown);
			addressEntity.setStreet(paramStreet);
			addressEntity.setHouse(paramHouse);
			addressEntity.setFlat(paramFlat);
			addressDao.insert(addressEntity);
			pw.println("Saved:" + addressEntity);

		} catch (Exception e) {
			pw.println("Error:" + e.toString());
		}

		pw.println("</body></html>");
		pw.close();
	}
}
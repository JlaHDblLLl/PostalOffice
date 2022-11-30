package by.grsu.lancevich.postaloffice.web.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
<<<<<<< HEAD
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
=======
>>>>>>> parent of 5d51eb5 (laba 7,8,9)
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
import by.grsu.lancevich.postaloffice.db.model.Item;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.web.dto.ItemDto;

public class ItemServlet extends HttpServlet{
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;
<<<<<<< HEAD
	private static final IDao<Integer, Person> userdataDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Item> itemDao = ItemDaoImpl.INSTANCE;

	private DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

=======
	private static final IDao<Integer, Item> itemDao = ItemDaoImpl.INSTANCE;

>>>>>>> parent of 5d51eb5 (laba 7,8,9)
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
<<<<<<< HEAD

		if (!ValidationUtils.isInteger(itemIdStr)) {
			res.sendError(400); // send HTTP status 400 and close response
			return;
		}

=======
>>>>>>> parent of 5d51eb5 (laba 7,8,9)
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
		req.getRequestDispatcher("item-edit.jsp").forward(req, res);
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
<<<<<<< HEAD
		item.setExpiration_date(new Date(DATE_FORMAT.parse(req.getParameter("expiration_date")).getTime()));
=======
		item.setExpiration_date(Timestamp.valueOf(req.getParameter("expiration_date")));
>>>>>>> parent of 5d51eb5 (laba 7,8,9)


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

package by.grsu.lancevich.postaloffice.web.context;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.grsu.lancevich.postaloffice.db.dao.AbstractDao;
import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.dao.impl.AddressDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.ItemDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.ParcelDaoImpl;
import by.grsu.lancevich.postaloffice.db.dao.impl.PersonDaoImpl;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Item;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class AppStartupListener implements ServletContextListener {
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;
	private static final IDao<Integer, Item> itemDao = ItemDaoImpl.INSTANCE;

	private static final String DB_NAME = "production-db";

	private void initDb() throws SQLException {
		AbstractDao.init(DB_NAME);
		if (!AbstractDao.isDbExist()) {
			System.out.println(String.format("DB '%s' doesn't exist and will be created", DB_NAME));
			AbstractDao.createDbSchema();
			loadInitialData();
		} else {
			System.out.println(String.format("DB '%s' exists", DB_NAME));
		}
	}

	private void loadInitialData() {

		createItem("");
		System.out.println("initial data created");
	}

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}
	private Date getCurrentDate() {
		return new Date(new Date().getTime());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized");
		try {
			initDb();
		} catch (SQLException e) {
			throw new RuntimeException("can't init DB", e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}




	private Address createAddress(String name) {
		Address entity = new Address();
		entity.setCountry(name + "Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		addressDao.insert(entity);
		System.out.println("created: " + entity);
		return entity;
	}
	private Person createPerson(String name) {
		Person entity = new Person();
		entity.setName(name + "Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(createAddress(name).getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		System.out.println("created: " + entity);
		return entity;
	}
	private Parcel createParcel(String name) {
		Parcel entity = new Parcel();
		entity.setSender_id(createPerson(name).getId());
		entity.setReceiver_id(createPerson(name).getId());
		entity.setDate_send(getCurrentDate());
		entity.setDate_accept(getCurrentDate());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentDate());
		entity.setAddress_from_id(createAddress(name).getId());
		entity.setAddress_to_id(createAddress(name).getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);
		System.out.println("created: " + entity);
		return entity;
	}
	private Item createItem(String name) {
		Item entity = new Item();
		entity.setParcel_id(createParcel(name).getId());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		itemDao.insert(entity);
		System.out.println("created: " + entity);
		return entity;
	}
}
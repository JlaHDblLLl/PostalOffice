package by.grsu.lancevich.postaloffice.db.dao.impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Item;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class ItemDaoTest extends AbstractTest{
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;
	private static final IDao<Integer, Item> itemDao = ItemDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Item entity = new Item();
		entity.setParcel_id(saveParcel("").getId());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		itemDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Item entity = new Item();
		entity.setParcel_id(saveParcel("").getId());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		itemDao.insert(entity);

		boolean newFragile = false;
		entity.setFragile(newFragile);
		itemDao.update(entity);

		Item updatedEntity = itemDao.getById(entity.getId());
		Assertions.assertEquals(newFragile, updatedEntity.getFragile());
	}

	@Test
	public void testDelete() {
		Item entity = new Item();
		entity.setParcel_id(saveParcel("").getId());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		itemDao.insert(entity);

		itemDao.delete(entity.getId());

		Assertions.assertNull(itemDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Item entity = new Item();
		entity.setParcel_id(saveParcel("").getId());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		itemDao.insert(entity);

		Item selectedEntity = itemDao.getById(entity.getId());

		Assertions.assertEquals(entity.getParcel_id(), selectedEntity.getParcel_id());
		Assertions.assertEquals(entity.getFragile(), selectedEntity.getFragile());
		Assertions.assertEquals(entity.getLength(), selectedEntity.getLength());
		Assertions.assertEquals(entity.getWidth(), selectedEntity.getWidth());
		Assertions.assertEquals(entity.getHeight(), selectedEntity.getHeight());
		Assertions.assertEquals(entity.getExpiration_date(), selectedEntity.getExpiration_date());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Item entity = new Item();
			entity.setParcel_id(saveParcel(i + "").getId());
			entity.setFragile(true);
			entity.setLength(1.2);
			entity.setWidth(2.0);
			entity.setHeight(3.0);
			entity.setWeight(12.2);
			entity.setExpiration_date(getCurrentTime());
			itemDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, itemDao.getAll().size());
	}

	private Address saveAddress(String name) {
		Address entity = new Address();
		entity.setCountry(name + "Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		addressDao.insert(entity);
		return entity;
	}
	private Person savePerson(String name) {
		Person entity = new Person();
		entity.setName(name + "Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(saveAddress(name + ": ").getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		return entity;
	}
	private Parcel saveParcel(String name) {
		Parcel entity = new Parcel();
		entity.setSender_id(savePerson(name).getId());
		entity.setReceiver_id(savePerson(name).getId());
		entity.setDate_send(getCurrentTime());
		entity.setDate_accept(getCurrentTime());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		entity.setAddress_from_id(saveAddress(name).getId());
		entity.setAddress_to_id(saveAddress(name).getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);
		return entity;
	}
}

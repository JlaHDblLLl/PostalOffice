package by.grsu.lancevich.postaloffice.db.dao.impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Parcel;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class ParcelDaoTest extends AbstractTest{
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;
	private static final IDao<Integer, Parcel> parcelDao = ParcelDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Parcel entity = new Parcel();
		entity.setSender_id(savePerson("").getId());
		entity.setReceiver_id(savePerson("").getId());
		entity.setDate_send(getCurrentTime());
		entity.setDate_accept(getCurrentTime());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		entity.setAddress_from_id(saveAddress("").getId());
		entity.setAddress_to_id(saveAddress("").getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Parcel entity = new Parcel();
		entity.setSender_id(savePerson("").getId());
		entity.setReceiver_id(savePerson("").getId());
		entity.setDate_send(getCurrentTime());
		entity.setDate_accept(getCurrentTime());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		entity.setAddress_from_id(saveAddress("").getId());
		entity.setAddress_to_id(saveAddress("").getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);

		Person newPerson = savePerson("");
		String newName = "Lena";
		newPerson.setName(newName);
		entity.setSender_id(newPerson.getId());
		entity.setUpdated(getCurrentTime());
		parcelDao.update(entity);

		Parcel updatedEntity = parcelDao.getById(entity.getId());
		Assertions.assertEquals(newPerson.getId(), updatedEntity.getSender_id());
		Assertions.assertNotEquals(updatedEntity.getUpdated(), updatedEntity.getCreated());
	}

	@Test
	public void testDelete() {
		Parcel entity = new Parcel();
		entity.setSender_id(savePerson("").getId());
		entity.setReceiver_id(savePerson("").getId());
		entity.setDate_send(getCurrentTime());
		entity.setDate_accept(getCurrentTime());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		entity.setAddress_from_id(saveAddress("").getId());
		entity.setAddress_to_id(saveAddress("").getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);

		parcelDao.delete(entity.getId());

		Assertions.assertNull(parcelDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Parcel entity = new Parcel();
		entity.setSender_id(savePerson("").getId());
		entity.setReceiver_id(savePerson("").getId());
		entity.setDate_send(getCurrentTime());
		entity.setDate_accept(getCurrentTime());
		entity.setFragile(true);
		entity.setLength(1.2);
		entity.setWidth(2.0);
		entity.setHeight(3.0);
		entity.setWeight(12.2);
		entity.setExpiration_date(getCurrentTime());
		entity.setAddress_from_id(saveAddress("").getId());
		entity.setAddress_to_id(saveAddress("").getId());
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		parcelDao.insert(entity);

		Parcel selectedEntity = parcelDao.getById(entity.getId());

		Assertions.assertEquals(entity.getSender_id(), selectedEntity.getSender_id());
		Assertions.assertEquals(entity.getReceiver_id(), selectedEntity.getReceiver_id());
		Assertions.assertEquals(entity.getDate_send(), selectedEntity.getDate_send());
		Assertions.assertEquals(entity.getDate_accept(), selectedEntity.getDate_accept());
		Assertions.assertEquals(entity.getFragile(), selectedEntity.getFragile());
		Assertions.assertEquals(entity.getLength(), selectedEntity.getLength());
		Assertions.assertEquals(entity.getWidth(), selectedEntity.getWidth());
		Assertions.assertEquals(entity.getHeight(), selectedEntity.getHeight());
		Assertions.assertEquals(entity.getWeight(), selectedEntity.getWeight());
		Assertions.assertEquals(entity.getExpiration_date(), selectedEntity.getExpiration_date());
		Assertions.assertEquals(entity.getAddress_from_id(), selectedEntity.getAddress_from_id());
		Assertions.assertEquals(entity.getAddress_to_id(), selectedEntity.getAddress_to_id());
		Assertions.assertEquals(entity.getCreated(), selectedEntity.getCreated());
		Assertions.assertEquals(entity.getUpdated(), selectedEntity.getUpdated());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Parcel entity = new Parcel();
			entity.setSender_id(savePerson(i + "").getId());
			entity.setReceiver_id(savePerson(i + "").getId());
			entity.setDate_send(getCurrentTime());
			entity.setDate_accept(getCurrentTime());
			entity.setFragile(true);
			entity.setLength(1.2);
			entity.setWidth(2.0);
			entity.setHeight(3.0);
			entity.setWeight(12.2);
			entity.setExpiration_date(getCurrentTime());
			entity.setAddress_from_id(saveAddress(i + "").getId());
			entity.setAddress_to_id(saveAddress(i + "").getId());
			entity.setCreated(getCurrentTime());
			entity.setUpdated(getCurrentTime());
			parcelDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, parcelDao.getAll().size());
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
}

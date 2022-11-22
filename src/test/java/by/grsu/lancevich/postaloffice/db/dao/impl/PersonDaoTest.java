package by.grsu.lancevich.postaloffice.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Address;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class PersonDaoTest extends AbstractTest{
	private static final IDao<Integer, Address> addressDao = AddressDaoImpl.INSTANCE;
	private static final IDao<Integer, Person> personDao = PersonDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Person entity = new Person();
		entity.setName("Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(saveAddress("").getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Person entity = new Person();
		entity.setName("Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(saveAddress("").getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);

		String newName = "Linda";
		String newPatronymic = "Andreevna";
		entity.setName(newName);
		entity.setPatronymic(newPatronymic);
		entity.setUpdated(getCurrentTime());
		personDao.update(entity);

		Person updatedEntity = personDao.getById(entity.getId());
		Assertions.assertEquals(newName, updatedEntity.getName());
		Assertions.assertEquals(newPatronymic, updatedEntity.getPatronymic());
		Assertions.assertNotEquals(updatedEntity.getUpdated(), updatedEntity.getCreated());
	}

	@Test
	public void testDelete() {
		Person entity = new Person();
		entity.setName("Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(saveAddress("").getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);

		personDao.delete(entity.getId());

		Assertions.assertNull(personDao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Person entity = new Person();
		entity.setName("Maxim");
		entity.setSurname("Lancevich");
		entity.setPatronymic("Andreevich");
		entity.setAddress_id(saveAddress("").getId());
		entity.setPassport_number("KH2819234");
		entity.setIndetification_number("5231102L000PS0");
		entity.setPassport_authority("Octyabrski ROVD");
		entity.setCreated(getCurrentTime());
		entity.setUpdated(getCurrentTime());
		personDao.insert(entity);

		Person selectedEntity = personDao.getById(entity.getId());

		Assertions.assertEquals(entity.getName(), selectedEntity.getName());
		Assertions.assertEquals(entity.getSurname(), selectedEntity.getSurname());
		Assertions.assertEquals(entity.getPatronymic(), selectedEntity.getPatronymic());
		Assertions.assertEquals(entity.getAddress_id(), selectedEntity.getAddress_id());
		Assertions.assertEquals(entity.getPassport_number(), selectedEntity.getPassport_number());
		Assertions.assertEquals(entity.getIndetification_number(), selectedEntity.getIndetification_number());
		Assertions.assertEquals(entity.getPassport_authority(), selectedEntity.getPassport_authority());
		Assertions.assertEquals(entity.getCreated(), selectedEntity.getCreated());
		Assertions.assertEquals(entity.getUpdated(), selectedEntity.getUpdated());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Person entity = new Person();
			entity.setName(i + ": " + "Maxim");
			entity.setSurname("Lancevich");
			entity.setPatronymic("Andreevich");
			entity.setAddress_id(saveAddress(i + ": ").getId());
			entity.setPassport_number("KH2819234");
			entity.setIndetification_number("5231102L000PS0");
			entity.setPassport_authority("Octyabrski ROVD");
			entity.setCreated(getCurrentTime());
			entity.setUpdated(getCurrentTime());
			personDao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, personDao.getAll().size());
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
}

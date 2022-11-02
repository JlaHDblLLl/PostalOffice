package by.grsu.lancevich.postaloffice.db.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Address;

public class AddressDaoTest extends AbstractTest{
	private static final IDao<Integer, Address> dao = AddressDaoImpl.INSTANCE;

	@Test
	public void testInsert() {
		Address entity = new Address();
		entity.setCountry("Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		
		dao.insert(entity);
		Assertions.assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		Address entity = new Address();
		entity.setCountry("Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		dao.insert(entity);

		String newHouse = "45";
		String newFlat = "23";
		entity.setHouse(newHouse);
		entity.setFlat(newFlat);
		dao.update(entity);

		Address updatedEntity = dao.getById(entity.getId());
		Assertions.assertEquals( newHouse, updatedEntity.getHouse());
		Assertions.assertEquals( newFlat, updatedEntity.getFlat());
	}

	@Test
	public void testDelete() {
		Address entity = new Address();
		entity.setCountry("Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		dao.insert(entity);

		dao.delete(entity.getId());

		Assertions.assertNull(dao.getById(entity.getId()));
	}

	@Test
	public void testGetById() {
		Address entity = new Address();
		entity.setCountry("Belarus");
		entity.setTown("Grodno");
		entity.setStreet("Kabyak street");
		entity.setHouse("35");
		entity.setFlat("69");
		dao.insert(entity);

		Address selectedEntity = dao.getById(entity.getId());

		Assertions.assertEquals(entity.getCountry(), selectedEntity.getCountry());
		Assertions.assertEquals(entity.getTown(), selectedEntity.getTown());
		Assertions.assertEquals(entity.getStreet(), selectedEntity.getStreet());
		Assertions.assertEquals(entity.getHouse(), selectedEntity.getHouse());
		Assertions.assertEquals(entity.getFlat(), selectedEntity.getFlat());
	}

	@Test
	public void testGetAll() {
		int expectedCount = getRandomNumber(1, 5);
		for (int i = 1; i <= expectedCount; i = i + 1) {
			Address entity = new Address();
			entity.setCountry(i + ": " + "Belarus");
			entity.setTown("Grodno");
			entity.setStreet("Kabyak street");
			entity.setHouse("35");
			entity.setFlat("69");
			dao.insert(entity);
		}

		Assertions.assertEquals(expectedCount, dao.getAll().size());
	}
}

package by.grsu.lancevich.postaloffice.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.lancevich.postaloffice.db.dao.AbstractDao;
import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Person;

public class PersonDaoImpl extends AbstractDao implements IDao<Integer, Person>{
	public static final PersonDaoImpl INSTANCE = new PersonDaoImpl();

	private PersonDaoImpl() {
		super();
	}

	@Override
	public void insert(Person entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into person(name, ser_name, patronymic, address_id, passport_number, indetification_number, passport_authority, created, updated) values(?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getSer_name());
			pstmt.setString(3, entity.getPatronymic());
			pstmt.setInt(4, entity.getAddress_id());
			pstmt.setString(5, entity.getPassport_number());
			pstmt.setString(6, entity.getIndetification_number());
			pstmt.setString(7, entity.getPassport_authority());
			pstmt.setTimestamp(8, entity.getCreated());
			pstmt.setTimestamp(9, entity.getUpdated());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "person"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Person entity", e);
		}

	}

	@Override
	public void update(Person entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update person set name=?, ser_name=?, patronymic=?, address_id=?, passport_number=?, indetification_number=?, passport_authority=?, updated=? where id=?");
			pstmt.setString(1, entity.getName());
			pstmt.setString(2, entity.getSer_name());
			pstmt.setString(3, entity.getPatronymic());
			pstmt.setInt(4, entity.getAddress_id());
			pstmt.setString(5, entity.getPassport_number());
			pstmt.setString(6, entity.getIndetification_number());
			pstmt.setString(7, entity.getPassport_authority());
			pstmt.setTimestamp(8, entity.getUpdated());
			pstmt.setInt(9, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Person entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from person where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Person entity", e);
		}
	}

	@Override
	public Person getById(Integer id) {
		Person entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from person where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Person entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Person> getAll() {
		List<Person> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from person");
			while (rs.next()) {
				Person entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Person entities", e);
		}

		return entitiesList;
	}

	private Person rowToEntity(ResultSet rs) throws SQLException {
		Person entity = new Person();
		entity.setId(rs.getInt("id"));
		entity.setName(rs.getString("name"));
		entity.setSer_name(rs.getString("ser_name"));
		entity.setPatronymic(rs.getString("patronymic"));
		entity.setAddress_id(rs.getInt("address_id"));
		entity.setPassport_number(rs.getString("passport_number"));
		entity.setIndetification_number(rs.getString("indetification_number"));
		entity.setPassport_authority(rs.getString("passport_authority"));
		entity.setCreated(rs.getTimestamp("created"));
		entity.setUpdated(rs.getTimestamp("updated"));
		return entity;
	}
}

package by.grsu.lancevich.postaloffice.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.lancevich.postaloffice.db.dao.AbstractDao;
import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Item;
public class ItemDaoImpl  extends AbstractDao implements IDao<Integer, Item>{
	public static final ItemDaoImpl INSTANCE = new ItemDaoImpl();

	private ItemDaoImpl() {
		super();
	}

	@Override
	public void insert(Item entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into item(parcel_id, weight, length, width, height, fragile, expiration_date) values(?,?,?,?,?,?,?)");

			pstmt.setInt(1, entity.getParcel_id());
			pstmt.setDouble(2, entity.getWeight());
			pstmt.setDouble(3, entity.getLength());
			pstmt.setDouble(4, entity.getWidth());
			pstmt.setDouble(5, entity.getHeight());
			pstmt.setBoolean(6, entity.getFragile());
			pstmt.setTimestamp(7, entity.getExpiration_date());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "item"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Item entity", e);
		}

	}

	@Override
	public void update(Item entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update item set parcel_id=?, weight=?, length=?, width=?, height=?, fragile=?, expiration_date=? where id=?");

			pstmt.setInt(1, entity.getParcel_id());
			pstmt.setDouble(2, entity.getWeight());
			pstmt.setDouble(3, entity.getLength());
			pstmt.setDouble(4, entity.getWidth());
			pstmt.setDouble(5, entity.getHeight());
			pstmt.setBoolean(6, entity.getFragile());
			pstmt.setTimestamp(7, entity.getExpiration_date());
			pstmt.setInt(8, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Item entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from item where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Item entity", e);
		}
	}

	@Override
	public Item getById(Integer id) {
		Item entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from item where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Item entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Item> getAll() {
		List<Item> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from item");
			while (rs.next()) {
				Item entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Item entities", e);
		}

		return entitiesList;
	}

	private Item rowToEntity(ResultSet rs) throws SQLException {
		Item entity = new Item();

		entity.setId(rs.getInt("id"));
		entity.setParcel_id(rs.getInt("parcel_id"));
		entity.setFragile(rs.getBoolean("fragile"));
		entity.setLength(rs.getDouble("length"));
		entity.setWidth(rs.getDouble("width"));
		entity.setHeight(rs.getDouble("height"));
		entity.setWeight(rs.getDouble("weight"));
		entity.setExpiration_date(rs.getTimestamp("expiration_date"));
		return entity;
	}
}

package by.grsu.lancevich.postaloffice.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.lancevich.postaloffice.db.dao.AbstractDao;
import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Parcel;

public class ParcelDaoImpl extends AbstractDao implements IDao<Integer, Parcel>{
	public static final ParcelDaoImpl INSTANCE = new ParcelDaoImpl();

	private ParcelDaoImpl() {
		super();
	}

	@Override
	public void insert(Parcel entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c
					.prepareStatement("insert into parcel(sender_id, receiver_id, date_send, date_accept, fragile, length, width, height, weight, expiration_date, address_from_id, address_to_id, created, updated) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			pstmt.setInt(1, entity.getSender_id());
			pstmt.setInt(2, entity.getReceiver_id());
			pstmt.setTimestamp(3, entity.getDate_send());
			pstmt.setTimestamp(4, entity.getDate_accept());
			pstmt.setBoolean(5, entity.getFragile());
			pstmt.setDouble(6, entity.getLength());
			pstmt.setDouble(7, entity.getWidth());
			pstmt.setDouble(8, entity.getHeight());
			pstmt.setDouble(9, entity.getWeight());
			pstmt.setTimestamp(10, entity.getExpiration_date());
			pstmt.setInt(11, entity.getAddress_from_id());
			pstmt.setInt(12, entity.getAddress_to_id());
			pstmt.setTimestamp(13, entity.getCreated());
			pstmt.setTimestamp(14, entity.getUpdated());
			pstmt.executeUpdate();
			entity.setId(getGeneratedId(c, "parcel"));
		} catch (SQLException e) {
			throw new RuntimeException("can't insert Parcel entity", e);
		}

	}

	@Override
	public void update(Parcel entity) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("update parcel set sender_id=?, receiver_id=?, date_send=?, date_accept=?, fragile=?, length=?, width=?, height=?, weight=?, expiration_date=?, address_from_id=?, address_to_id=?, updated=? where id=?");
			pstmt.setInt(1, entity.getSender_id());
			pstmt.setInt(2, entity.getReceiver_id());
			pstmt.setTimestamp(3, entity.getDate_send());
			pstmt.setTimestamp(4, entity.getDate_accept());
			pstmt.setBoolean(5, entity.getFragile());
			pstmt.setDouble(6, entity.getLength());
			pstmt.setDouble(7, entity.getWidth());
			pstmt.setDouble(8, entity.getHeight());
			pstmt.setDouble(9, entity.getWeight());
			pstmt.setTimestamp(10, entity.getExpiration_date());
			pstmt.setInt(11, entity.getAddress_from_id());
			pstmt.setInt(12, entity.getAddress_to_id());
			pstmt.setTimestamp(13, entity.getUpdated());
			pstmt.setInt(14, entity.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't update Parcel entity", e);
		}

	}

	@Override
	public void delete(Integer id) {
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("delete from parcel where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("can't delete Parcel entity", e);
		}
	}

	@Override
	public Parcel getById(Integer id) {
		Parcel entity = null;
		try (Connection c = createConnection()) {
			PreparedStatement pstmt = c.prepareStatement("select * from parcel where id=?");
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				entity = rowToEntity(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't get Parcel entity by id", e);
		}

		return entity;
	}

	@Override
	public List<Parcel> getAll() {
		List<Parcel> entitiesList = new ArrayList<>();
		try (Connection c = createConnection()) {
			ResultSet rs = c.createStatement().executeQuery("select * from parcel");
			while (rs.next()) {
				Parcel entity = rowToEntity(rs);
				entitiesList.add(entity);
			}
		} catch (SQLException e) {
			throw new RuntimeException("can't select Parcel entities", e);
		}

		return entitiesList;
	}

	private Parcel rowToEntity(ResultSet rs) throws SQLException {
		Parcel entity = new Parcel();

		entity.setId(rs.getInt("id"));
		entity.setSender_id(rs.getInt("sender_id"));
		entity.setReceiver_id(rs.getInt("receiver_id"));
		entity.setDate_send(rs.getTimestamp("date_send"));
		entity.setDate_accept(rs.getTimestamp("date_accept"));
		entity.setFragile(rs.getBoolean("fragile"));
		entity.setLength(rs.getDouble("length"));
		entity.setWidth(rs.getDouble("width"));
		entity.setHeight(rs.getDouble("height"));
		entity.setWeight(rs.getDouble("weight"));
		entity.setExpiration_date(rs.getTimestamp("expiration_date"));
		entity.setAddress_from_id(rs.getInt("address_from_id"));
		entity.setAddress_to_id(rs.getInt("address_to_id"));
		entity.setCreated(rs.getTimestamp("created"));
		entity.setUpdated(rs.getTimestamp("updated"));
		return entity;
	}
}

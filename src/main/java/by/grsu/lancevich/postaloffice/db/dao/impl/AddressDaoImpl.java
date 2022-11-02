package by.grsu.lancevich.postaloffice.db.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.grsu.lancevich.postaloffice.db.dao.AbstractDao;
import by.grsu.lancevich.postaloffice.db.dao.IDao;
import by.grsu.lancevich.postaloffice.db.model.Address;


public class AddressDaoImpl extends AbstractDao implements IDao<Integer, Address> {
	
	
		public static final AddressDaoImpl INSTANCE = new AddressDaoImpl();
		
		private AddressDaoImpl() {
			super();
		}

		@Override
		public void insert(Address entity) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("insert into address(country, town, street, house, flat) values(?,?,?,?,?)");
				pstmt.setString(1, entity.getCountry());
				pstmt.setString(2, entity.getTown());
				pstmt.setString(3, entity.getStreet());
				pstmt.setString(4, entity.getHouse());
				pstmt.setString(5, entity.getFlat());
				pstmt.executeUpdate();
				entity.setId(getGeneratedId(c, "address"));
			} catch (SQLException e) {
				throw new RuntimeException("can't insert Address entity", e);
			}
		}

		@Override
		public void update(Address entity) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("update address set country=?, town=?, street=?, house=?, flat=? where id=?");
				pstmt.setString(1, entity.getCountry());
				pstmt.setString(2, entity.getTown());
				pstmt.setString(3, entity.getStreet());
				pstmt.setString(4, entity.getHouse());
				pstmt.setString(5, entity.getFlat());
				pstmt.setInt(6, entity.getId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("can't update Address entity", e);
			}
		}

		@Override
		public void delete(Integer id) {
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("delete from address where id=?");
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException("can't delete Address entity", e);
			}

		}

		@Override
		public Address getById(Integer id) {
			Address entity = null;
			try (Connection c = createConnection()) {
				PreparedStatement pstmt = c.prepareStatement("select * from address where id=?");
				pstmt.setInt(1, id);

				ResultSet rs = pstmt.executeQuery();

				if (rs.next()) {
					entity = rowToEntity(rs);
				}
			} catch (SQLException e) {
				throw new RuntimeException("can't get Address entity by id", e);
			}

			return entity;
		}

		@Override
		public List<Address> getAll() {
			List<Address> entitiesList = new ArrayList<>();
			try (Connection c = createConnection()) {
				ResultSet rs = c.createStatement().executeQuery("select * from address");
				while (rs.next()) {
					Address entity = rowToEntity(rs);
					entitiesList.add(entity);
				}
			} catch (SQLException e) {
				throw new RuntimeException("can't select Address entities", e);
			}

			return entitiesList;
		}

		private Address rowToEntity(ResultSet rs) throws SQLException {
			Address entity = new Address();
			entity.setId(rs.getInt("id"));
			entity.setCountry(rs.getString("country"));
			entity.setTown(rs.getString("town"));
			entity.setStreet(rs.getString("street"));
			entity.setHouse(rs.getString("house"));
			entity.setFlat(rs.getString("flat"));
			return entity;
		}
}

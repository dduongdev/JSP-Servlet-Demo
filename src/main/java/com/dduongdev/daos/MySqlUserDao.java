package com.dduongdev.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dduongdev.entities.User;
import com.dduongdev.utils.DbConnector;

public class MySqlUserDao implements UserDao {

	@Override
	public Optional<User> findByUsername(String username) {
		String query = MySqlCommands.USER_FIND_BY_USERNAME_QUERY;

		try (Connection connection = DbConnector.getInstance().getConnection();
				PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, username);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				User user = mapFrom(rs);
				return Optional.of(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return Optional.empty();
	}

	@Override
	public void save(User user) {
		String query = MySqlCommands.USER_SAVE_QUERY;

		try (Connection connection = DbConnector.getInstance().getConnection();
				PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setTimestamp(3, Timestamp.valueOf(user.getCreatedAt()));

			int rowsAffected = stmt.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet generatedKey = stmt.getGeneratedKeys();
				if (generatedKey.next()) {
					user.setId(generatedKey.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private User mapFrom(ResultSet rs) throws SQLException {
		return new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
				rs.getTimestamp("created_at").toLocalDateTime());
	}
	
	@Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = MySqlCommands.USER_FIND_ALL_QUERY;

        try (Connection connection = DbConnector.getInstance().getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                users.add(mapFrom(rs));
            }
        } catch (SQLException e) {
        	throw new RuntimeException(e);
        }

        return users;
    }
}

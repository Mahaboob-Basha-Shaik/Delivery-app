package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	private static final String INSERT_USER_QUERY = "INSERT INTO `Users` (`name`, `username`, `password`, `email`, `phone`, `address`, `role`, `createDate`, `lastLoginDate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_USER_QUERY = "SELECT * FROM `Users` WHERE `userId` = ?";
	private static final String UPDATE_USER_QUERY = "UPDATE `Users` SET `name` = ?, `password` = ?, `phone` = ?, `address` = ?, `role` = ? WHERE `userId` = ?";
	private static final String DELETE_USER_QUERY = "DELETE FROM `Users` WHERE `userId` = ?";
	private static final String GET_ALL_USERS_QUERY = "SELECT * FROM `Users`";
	private static final String LOGIN_QUERY = "SELECT * FROM `Users` WHERE (`username` = ? OR `email` = ?) AND `password` = ?";

	// ADD USER //
	@Override
	public boolean addUser(User user) {
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY)) {

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getPassword()); // ⚠️ In production, hash the password!
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getRole());
			preparedStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis())); // createDate
			preparedStatement.setTimestamp(9, new Timestamp(System.currentTimeMillis())); // lastLoginDate

			int result = preparedStatement.executeUpdate();
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// GET USER BY ID //
	@Override
	public User getUser(int userId) {
		User user = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY)) {

			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = extractUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	// UPDATE USER //
	@Override
	public void updateUser(User user) {
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY)) {

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPassword()); // ⚠️ In production, hash the password
			preparedStatement.setString(3, user.getPhone());
			preparedStatement.setString(4, user.getAddress());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getUserId());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// DELETE USER //
	@Override
	public void deleteUser(int userId) {
		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY)) {

			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// GET ALL USERS //
	@Override
	public List<User> getAllUsers() {
		List<User> usersList = new ArrayList<>();

		try (Connection connection = DBConnection.getConnection(); Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(GET_ALL_USERS_QUERY);

			while (resultSet.next()) {
				User user = extractUser(resultSet);
				usersList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usersList;
	}

	// LOGIN METHOD //
	@Override
	public User login(String usernameOrEmail, String password) {
		User user = null;

		try (Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_QUERY)) {

			preparedStatement.setString(1, usernameOrEmail);
			preparedStatement.setString(2, usernameOrEmail);
			preparedStatement.setString(3, password); // ⚠️ Use hashing for passwords in production

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = extractUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public User getUserById(int userId) {
		User user = null;
		String sql = "SELECT * FROM users WHERE userId = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreateDate(rs.getTimestamp("createDate"));
				user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	private User extractUser(ResultSet rs) throws SQLException {
		User user = new User();

		user.setUserId(rs.getInt("userId"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setAddress(rs.getString("address"));
		user.setRole(rs.getString("role"));
		user.setCreateDate(rs.getTimestamp("createDate"));
		user.setLastLoginDate(rs.getTimestamp("lastLoginDate"));

		return user;
	}
}

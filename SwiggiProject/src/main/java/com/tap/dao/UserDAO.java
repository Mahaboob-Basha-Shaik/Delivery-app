package com.tap.dao;

import java.util.List;
import com.tap.model.User;

public interface UserDAO {

	boolean addUser(User user);

	User getUser(int userId);

	void updateUser(User user);

	void deleteUser(int userId);

	User getUserById(int userId);

	List<User> getAllUsers();

	User login(String usernameOrEmail, String password);
}

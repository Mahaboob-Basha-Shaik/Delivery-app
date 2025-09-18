package com.amazonclone.services;

import java.util.Optional;

import com.amazonclone.model.User;

public interface UserService {

	User register(User user);

	Optional<User> login(String email, String password);

	Optional<User> getUserByEmail(String email);

	Optional<User> getUserById(Long userId);

}

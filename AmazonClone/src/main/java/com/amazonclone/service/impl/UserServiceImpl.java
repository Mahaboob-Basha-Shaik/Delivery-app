package com.amazonclone.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.model.User;
import com.amazonclone.repository.UserRepository;
import com.amazonclone.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) {
		return userRepository.save(user);
	}

	@Override
	public Optional<User> login(String email, String password) {
		Optional<User> userOpt = userRepository.findByEmail(email);
		if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
			return userOpt;
		}
		return Optional.empty();
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

}

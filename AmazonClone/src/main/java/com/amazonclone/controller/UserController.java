package com.amazonclone.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.model.User;
import com.amazonclone.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Register user
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	// Login user
	@PostMapping("/login")
	public Optional<User> login(@RequestParam String email, @RequestParam String password) {
		return userService.login(email, password);
	}
}

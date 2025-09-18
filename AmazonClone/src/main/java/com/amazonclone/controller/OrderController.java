package com.amazonclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.model.Order;
import com.amazonclone.model.User;
import com.amazonclone.services.OrderService;
import com.amazonclone.services.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserService userService;

	// ✅ Place Order
	@PostMapping("/place")
	public Order placeOrder(@RequestParam Long userId, @RequestParam String paymentMethod,
			@RequestParam String shippingAddress) {

		User user = userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		return orderService.placeOrder(user, paymentMethod, shippingAddress);
	}

	// ✅ Get all orders by user
	@GetMapping("/{userId}")
	public List<Order> getOrdersByUser(@PathVariable Long userId) {
		User user = userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
		return orderService.getOrdersByUser(user);
	}
}

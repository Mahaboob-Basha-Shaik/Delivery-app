package com.amazonclone.services;

import com.amazonclone.model.Order;
import com.amazonclone.model.User;

import java.util.List;

public interface OrderService {
	Order placeOrder(User user);

	List<Order> getOrdersByUser(User user);

	Order placeOrder(User user, String paymentMethod, String shippingAddress);
}

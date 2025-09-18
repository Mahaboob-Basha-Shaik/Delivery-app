package com.amazonclone.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.model.CartItem;
import com.amazonclone.model.Order;
import com.amazonclone.model.OrderItem;
import com.amazonclone.model.Product;
import com.amazonclone.model.User;
import com.amazonclone.repository.CartItemRepository;
import com.amazonclone.repository.OrderItemRepository;
import com.amazonclone.repository.OrderRepository;
import com.amazonclone.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public Order placeOrder(User user) {
		List<CartItem> cartItems = cartItemRepository.findByUser(user);

		if (cartItems.isEmpty()) {
			throw new RuntimeException("Cart is empty");
		}

		Order order = new Order();
		order.setUser(user);
		order.setDate(LocalDateTime.now());
		order.setStatus("PLACED");

		double total = 0.0;
		List<OrderItem> orderItems = new ArrayList<>();

		for (CartItem cartItem : cartItems) {
			Product product = cartItem.getProduct();
			int quantity = cartItem.getQuantity();

			if (product.getStock() < quantity) {
				throw new RuntimeException("Not enough stock for product: " + product.getName());
			}

			// Update stock
			product.setStock(product.getStock() - quantity);

			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(product);
			orderItem.setQuantity(quantity);
			orderItem.setPrice(product.getPrice());

			total += quantity * product.getPrice();
			orderItems.add(orderItem);
		}

		order.setTotalAmount(total);
		order.setItems(orderItems);

		Order savedOrder = orderRepository.save(order);
		orderItemRepository.saveAll(orderItems);

		cartItemRepository.deleteAllByUser(user); // Clear cart after placing order

		return savedOrder;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		return orderRepository.findByUser(user);
	}
}

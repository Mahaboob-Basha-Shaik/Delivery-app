package com.tap.dao;

import com.tap.model.Order;
import com.tap.model.OrderItem;

import java.util.List;

public interface OrderDAO {

	void addOrder(Order order, List<OrderItem> orderItems);

	Order getOrderById(int orderId);

	void updateOrder(Order order);

	void deleteOrder(int orderId);

	List<Order> getAllOrders();

	void addOrder(Order order);
}

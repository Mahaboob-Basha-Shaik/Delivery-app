package com.tap.dao;

import com.tap.model.OrderItem;
import java.util.List;

public interface OrderItemDAO {

	void addOrderItem(OrderItem orderItem);

	OrderItem getOrderItemById(int orderItemId);

	List<OrderItem> getOrderItemsByOrderId(int orderId);

	void updateOrderItem(OrderItem orderItem);

	void deleteOrderItem(int orderItemId);

	List<OrderItem> getAllOrderItems();
}

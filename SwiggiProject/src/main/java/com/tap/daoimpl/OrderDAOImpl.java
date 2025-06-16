package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	private static final String INSERT_ORDER = "INSERT INTO `orders` (userId, restaurantId, orderDate, totalAmount, status, paymentMethod) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String INSERT_ORDER_ITEM = "INSERT INTO `orderitem` (orderId, menuId, quantity, totalAmount) VALUES (?, ?, ?, ?)";
	private static final String SELECT_BY_ID = "SELECT * FROM `orders` WHERE orderId = ?";
	private static final String UPDATE_QUERY = "UPDATE `orders` SET userId = ?, restaurantId = ?, orderDate = ?, totalAmount = ?, status = ?, paymentMethod = ? WHERE orderId = ?";
	private static final String DELETE_QUERY = "DELETE FROM `orders` WHERE orderId = ?";
	private static final String SELECT_ALL = "SELECT * FROM `orders`";

	@Override
	public void addOrder(Order order, List<OrderItem> orderItems) {
		try (Connection conn = DBConnection.getConnection()) {
			conn.setAutoCommit(false); // Begin transaction

			// Insert into orders table
			try (PreparedStatement orderStmt = conn.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
				orderStmt.setInt(1, order.getUserId());
				orderStmt.setInt(2, order.getRestaurantId());
				orderStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis())); // Set current time
				orderStmt.setDouble(4, order.getTotalAmount());
				orderStmt.setString(5, order.getStatus());
				orderStmt.setString(6, order.getPaymentMethod());
				orderStmt.executeUpdate();

				// Get generated orderId
				ResultSet rs = orderStmt.getGeneratedKeys();
				int orderId = -1;
				if (rs.next()) {
					orderId = rs.getInt(1);
					order.getOrderID(); // Update order object with ID
				}

				// Insert each order item
				try (PreparedStatement itemStmt = conn.prepareStatement(INSERT_ORDER_ITEM)) {
					for (OrderItem item : orderItems) {
						itemStmt.setInt(1, orderId);
						itemStmt.setInt(2, item.getMenuId());
						itemStmt.setInt(3, item.getQuantity());
						itemStmt.setDouble(4, item.getTotalamount());
						itemStmt.addBatch();
					}
					itemStmt.executeBatch();
				}

				conn.commit(); // Commit transaction
			} catch (SQLException e) {
				conn.rollback(); // Roll back if any error
				throw new RuntimeException("Failed to add order and items", e);
			} finally {
				conn.setAutoCommit(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrderById(int orderId) {
		Order order = null;
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {

			stmt.setInt(1, orderId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				order = extractOrder(rs);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public void updateOrder(Order order) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(UPDATE_QUERY)) {

			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getRestaurantId());
			stmt.setTimestamp(3, order.getOrderDate());
			stmt.setDouble(4, order.getTotalAmount());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getPaymentMethod());
			stmt.setInt(7, order.getOrderID());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY)) {

			stmt.setInt(1, orderId);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<>();
		try (Connection conn = DBConnection.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ALL)) {

			while (rs.next()) {
				orders.add(extractOrder(rs));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void addOrder(Order order) {
		try (Connection conn = DBConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `orders` (userId, restaurantId, orderDate, totalAmount, status, paymentMethod) VALUES (?, ?, ?, ?, ?, ?)")) {

			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getRestaurantId());
			stmt.setTimestamp(3, order.getOrderDate());
			stmt.setDouble(4, order.getTotalAmount());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getPaymentMethod());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Order extractOrder(ResultSet rs) throws SQLException {
		int orderId = rs.getInt("orderId");
		int userId = rs.getInt("userId");
		int restaurantId = rs.getInt("restaurantId");
		Timestamp orderDate = rs.getTimestamp("orderDate");
		double totalAmount = rs.getDouble("totalAmount");
		String status = rs.getString("status");
		String paymentMethod = rs.getString("paymentMethod");

		return new Order(orderId, userId, restaurantId, orderDate, totalAmount, status, paymentMethod);
	}

}

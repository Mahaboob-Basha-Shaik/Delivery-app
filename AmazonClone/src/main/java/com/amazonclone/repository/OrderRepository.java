package com.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amazonclone.model.Order;
import com.amazonclone.model.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
	List<Order> findByUser(User user);
}

package com.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amazonclone.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}

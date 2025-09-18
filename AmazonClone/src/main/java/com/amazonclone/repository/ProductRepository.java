package com.amazonclone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.amazonclone.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

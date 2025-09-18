package com.amazonclone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.model.Product;
import com.amazonclone.repository.ProductRepository;
import com.amazonclone.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(existingProduct -> {
			existingProduct.setName(updatedProduct.getName());
			existingProduct.setDescription(updatedProduct.getDescription());
			existingProduct.setPrice(updatedProduct.getPrice());
			existingProduct.setImage(updatedProduct.getImage());
			existingProduct.setStock(updatedProduct.getStock());
			return productRepository.save(existingProduct);
		}).orElse(null);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}

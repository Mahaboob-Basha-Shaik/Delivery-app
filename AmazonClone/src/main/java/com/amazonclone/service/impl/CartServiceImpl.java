package com.amazonclone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonclone.model.CartItem;
import com.amazonclone.model.Product;
import com.amazonclone.model.User;
import com.amazonclone.repository.CartItemRepository;
import com.amazonclone.services.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartItemRepository cartItemRepository;

	@Override
	public CartItem addToCart(User user, Product product, int quantity) {
		CartItem item = cartItemRepository.findByUserAndProduct(user, product).orElse(new CartItem(user, product, 0));
		item.setQuantity(item.getQuantity() + quantity);
		return cartItemRepository.save(item);
	}

	@Override
	public List<CartItem> getCartItemsByUser(User user) {
		return cartItemRepository.findByUser(user);
	}

	@Override
	public void removeItem(Long cartItemId) {
		cartItemRepository.deleteById(cartItemId);
	}

	@Override
	public void clearCart(User user) {
		cartItemRepository.deleteAllByUser(user);
	}
}

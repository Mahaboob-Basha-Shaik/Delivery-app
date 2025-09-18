package com.amazonclone.services;

import com.amazonclone.model.CartItem;
import com.amazonclone.model.Product;
import com.amazonclone.model.User;

import java.util.List;

public interface CartService {
	CartItem addToCart(User user, Product product, int quantity);

	List<CartItem> getCartItemsByUser(User user);

	void removeItem(Long cartItemId);

	void clearCart(User user);

	CartItem addToCart(Product user, Product product, int quantity);

	List<CartItem> getCartItemsByUser(Product user);

	void clearCart(Product user);
}

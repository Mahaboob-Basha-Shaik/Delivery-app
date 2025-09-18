package com.amazonclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonclone.model.CartItem;
import com.amazonclone.model.Product;
import com.amazonclone.model.User;
import com.amazonclone.services.CartService;
import com.amazonclone.services.ProductService;
import com.amazonclone.services.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductService productService;

	@PostMapping("/add")
	public CartItem addToCart(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {

		User user = userService.getUserById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		Product product = productService.getProductById(productId)
				.orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));

		return cartService.addToCart(user, product, quantity);
	}

	@GetMapping("/{userId}")
	public List<CartItem> getCart(@PathVariable Long userId) {
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		return cartService.getCartItemsByUser(user);
	}

	@DeleteMapping("/remove/{cartItemId}")
	public void removeItem(@PathVariable Long cartItemId) {
		cartService.removeItem(cartItemId);
	}

	@DeleteMapping("/clear/{userId}")
	public void clearCart(@PathVariable Long userId) {
		User user = userService.getUserById(userId)
				.orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
		cartService.clearCart(user);
	}
}

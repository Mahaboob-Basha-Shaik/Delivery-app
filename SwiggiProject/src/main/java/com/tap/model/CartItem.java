package com.tap.model;

public class CartItem {
	private Menu menu;
	private int quantity;

	public CartItem(Menu menu, int quantity) {
		this.menu = menu;
		this.quantity = quantity;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return menu.getPrice() * quantity;
	}

	@Override
	public String toString() {
		return "CartItem [menu=" + menu + ", quantity=" + quantity + "]";
	}

}

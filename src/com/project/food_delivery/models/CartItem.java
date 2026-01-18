package com.project.food_delivery.models;

public class CartItem {
	
	private int cartItemId;
	private int cartId;
	private int itemId;
	private int quantity;
	
	public CartItem(int cartItemId, int cartId, int itemId, int quantity) {
		super();
		this.cartItemId = cartItemId;
		this.cartId = cartId;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", cartId=" + cartId + ", itemId=" + itemId + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
	

}

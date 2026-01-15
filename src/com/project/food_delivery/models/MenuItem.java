package com.project.food_delivery.models;

public class MenuItem {
	
	private int itemId,restaurantId;
	private String itemName;
	private double price;
	private boolean available;
	
	public MenuItem() {}

	public MenuItem(int restaurantId, String itemName, double price, boolean available) {
		super();
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.available = available;
	}

	@Override
	public String toString() {
		return "MenuItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", price="
				+ price + ", available=" + available + "]";
	}
	
	

}

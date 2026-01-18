package com.project.food_delivery.models;

public class MenuItem {
	
	private int itemId;
	private int restaurantId;
	private String itemName;
	private double price;
	private boolean isAvailable;
	
	public MenuItem() {}

	public MenuItem(int itemId, int restaurantId, String itemName, double price, boolean isAvailable) {
		super();
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "MenuItem [itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName=" + itemName + ", price="
				+ price + ", isAvailable=" + isAvailable + "]";
	}
	
	

}

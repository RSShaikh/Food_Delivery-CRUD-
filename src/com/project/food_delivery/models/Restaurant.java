package com.project.food_delivery.models;

public class Restaurant {
	private int restaurantId;
	private String name,address;
	private double rating;
	private boolean isActive;
	
	public Restaurant(int restaurantId, String name, String address, double rating, boolean isActive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
	}
	

	public int getRestaurantId() {
		return restaurantId;
	}



	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public double getRating() {
		return rating;
	}



	public void setRating(double rating) {
		this.rating = rating;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", rating="
				+ rating + ", isActive=" + isActive + "]";
	}
	
}

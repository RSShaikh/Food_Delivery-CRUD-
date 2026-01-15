package com.project.food_delivery.models;

import java.security.Timestamp;

public class Order {
	
	private int orderId,userId,restaurantId;
	private double totalAmount;
	private String orderStatus;
	private Timestamp orderDate;
	
	public Order() {}

	public Order(int userId, int restaurantId, double totalAmount, String orderStatus,
			Timestamp orderDate) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}
	
}

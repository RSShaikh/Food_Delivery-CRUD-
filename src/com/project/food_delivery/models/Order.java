package com.project.food_delivery.models;

import java.sql.Timestamp;

public class Order {
	
	private int orderId;
	private int userId;
	private int restaurantId;
	private double totalAmount;
	private String orderStatus;
	private Timestamp orderDate;
	

	public Order(int orderId, int userId, int restaurantId, double totalAmount, String orderStatus,
			Timestamp orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", totalAmount="
				+ totalAmount + ", orderStatus=" + orderStatus + ", orderDate=" + orderDate + "]";
	}
	
}

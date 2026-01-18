package com.project.food_delivery.models;

import java.sql.Timestamp;

public class Delivery {
	private int deliveryId;
	private int orderId;
	private int agentId;
	private String deliveryStatus;
	private Timestamp deliveryTime;
	public Delivery(int deliveryId, int orderId, int agentId, String deliveryStatus, Timestamp deliveryTime) {
		super();
		this.deliveryId = deliveryId;
		this.orderId = orderId;
		this.agentId = agentId;
		this.deliveryStatus = deliveryStatus;
		this.deliveryTime = deliveryTime;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Timestamp getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Timestamp deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	@Override
	public String toString() {
		return "Delivery [deliveryId=" + deliveryId + ", orderId=" + orderId + ", agentId=" + agentId
				+ ", deliveryStatus=" + deliveryStatus + ", deliveryTime=" + deliveryTime + "]";
	}

}

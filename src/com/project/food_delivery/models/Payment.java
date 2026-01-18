package com.project.food_delivery.models;

import java.sql.Timestamp;

public class Payment {

	private int paymentId;
	private int orderId;
	private double amount;
	private String paymentMethod;
	private String paymentStatus;
	private Timestamp paymentDate;
	
	public Payment(int paymentId, int orderId, double amount, String paymentMethod, String paymentStatus,
			Timestamp paymentDate) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.paymentDate = paymentDate;
	}
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate + "]";
	}
	
	
}

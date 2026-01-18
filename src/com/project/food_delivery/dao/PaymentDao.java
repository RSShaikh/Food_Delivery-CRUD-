package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Payment;

public interface PaymentDao {
	
	boolean addPayment(Payment payment); 
	Payment getPaymentById(int paymentId); 
	Payment getPaymentByOrderId(int orderId); 
	List<Payment> getAllPayments(); 
	boolean updatePaymentStatus(int paymentId, String newStatus);
	boolean deletePayment(int paymentId);

}

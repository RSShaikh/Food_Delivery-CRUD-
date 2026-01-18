package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Delivery;

public interface DeliveryDao {

	boolean assignDelivery(Delivery delivery); 
	Delivery getDeliveryByOrderId(int orderId); 
	Delivery getDeliveryById(int deliveryId); 
	List<Delivery> getAllDeliveries(); 
	boolean updateDeliveryStatus(int deliveryId, String newStatus); 
	boolean markDelivered(int deliveryId); 
	boolean deleteDelivery(int deliveryId);
	
}

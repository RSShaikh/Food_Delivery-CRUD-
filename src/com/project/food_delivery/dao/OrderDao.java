package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Order;

public interface OrderDao {
	
	boolean placeOrder(Order order);
	Order getOrderById(int orderId);
	List<Order> getOrdersByUser(int userId); 
	List<Order> getAllOrders(); 
	boolean updateOrderStatus(int orderId, String newStatus); 
	boolean deleteOrder(int orderId);

}

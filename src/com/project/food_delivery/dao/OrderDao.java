package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Order;

public interface OrderDao {
	
	void createOrder(Order order);

    Order getOrderById(int orderId);

    List<Order> getOrdersByUserId(int userId);

    void updateOrderStatus(int orderId, String status);

    void deleteOrder(int orderId);

}

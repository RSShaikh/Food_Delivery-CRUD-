package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Cart;

public interface CartDao {
	boolean createCart(Cart cart);
	Cart getCartByUserId(int userId); 
	List<Cart> getAllCarts(); 
	boolean deleteCart(int cartId);

}

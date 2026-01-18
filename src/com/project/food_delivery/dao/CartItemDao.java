package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.CartItem;

public interface CartItemDao {

	boolean addCartItem(CartItem item); 
	boolean updateCartItem(CartItem item);
	boolean deleteCartItem(int cartItemId); 
	List<CartItem> getItemsByCartId(int cartId); 
	CartItem getCartItemById(int cartItemId);
}

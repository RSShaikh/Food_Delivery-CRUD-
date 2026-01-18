package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.MenuItem;

public interface MenuItemDao {
	
	boolean addMenuItem(MenuItem item); 
	boolean updateMenuItem(MenuItem item); 
	boolean deleteMenuItemById(int id); 
	MenuItem getMenuItemById(int id); 
	List<MenuItem> getMenuItemsByRestaurant(int restaurantId); 
	List<MenuItem> getAllMenuItems();

}

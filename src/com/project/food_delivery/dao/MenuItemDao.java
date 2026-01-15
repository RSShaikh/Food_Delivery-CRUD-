package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.MenuItem;

public interface MenuItemDao {
	
	void addMenuItem(MenuItem item);

    MenuItem getMenuItemById(int itemId);

    List<MenuItem> getMenuItemsByRestaurant(int restaurantId);

    void updateMenuItem(MenuItem item);

    void deleteMenuItem(int itemId);

}

package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.Restaurant;

public interface RestaurantDao {
	
	boolean addRestaurant(Restaurant r); 
	boolean updateRestaurant(Restaurant r); 
	boolean deleteRestaurantById(int id);
	Restaurant getRestaurantById(int id); 
	List<Restaurant> getAllRestaurants();

}

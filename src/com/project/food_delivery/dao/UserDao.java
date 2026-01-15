package com.project.food_delivery.dao;

import java.util.List;

import com.project.food_delivery.models.User;


public interface UserDao {
	public boolean addUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUserById(int id);
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public List<User> getAllUser();

}

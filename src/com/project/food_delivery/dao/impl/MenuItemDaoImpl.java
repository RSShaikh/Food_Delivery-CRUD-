package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.MenuItemDao;
import com.project.food_delivery.models.MenuItem;

public class MenuItemDaoImpl implements MenuItemDao {
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";

	@Override
	public boolean addMenuItem(MenuItem item) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password);
			query = "INSERT INTO menu_items(restaurant_id, item_name, price, is_available) VALUES(?,?,?,?)";
			ps = con.prepareStatement(query); 
			ps.setInt(1, item.getRestaurantId()); 
			ps.setString(2, item.getItemName()); 
			ps.setDouble(3, item.getPrice()); 
			ps.setBoolean(4, item.isAvailable()); 
			rowCount = ps.executeUpdate(); 
			if (rowCount == 1) response = true; 
			} 
		catch (Exception e) { 
			e.printStackTrace(); 
			} 
		finally { 
			try { 
				con.close(); 
			} 
			catch (SQLException e) {
				e.printStackTrace(); 
				} 
			}
		return response; 
	}

	@Override
	public boolean updateMenuItem(MenuItem item) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password); 
			query = "UPDATE menu_items SET restaurant_id=?, item_name=?, price=?, is_available=? WHERE item_id=?"; 
			ps = con.prepareStatement(query); 
			ps.setInt(1, item.getRestaurantId());
			ps.setString(2, item.getItemName()); 
			ps.setDouble(3, item.getPrice()); 
			ps.setBoolean(4, item.isAvailable()); 
			ps.setInt(5, item.getItemId()); 
			rowCount = ps.executeUpdate();
			if (rowCount == 1) response = true; 
			}
		catch (Exception e) { 
			e.printStackTrace();
			} 
		finally {
			try {
				con.close();
				} 
			catch (SQLException e) {
				e.printStackTrace();
				}
			}
		return response;
	}

	@Override
	public boolean deleteMenuItemById(int id) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password); 
			query = "DELETE FROM menu_items WHERE item_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rowCount = ps.executeUpdate(); 
			if (rowCount == 1) response = true; 
			} 
		catch (Exception e) {
			e.printStackTrace();
			} 
		finally { 
			try {
				con.close(); 
				} 
			catch (SQLException e) {
				e.printStackTrace();
				} 
			} 
		return response;
	}

	@Override
	public MenuItem getMenuItemById(int id) {
		MenuItem item = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			query = "SELECT * FROM menu_items WHERE item_id=?";
			ps = con.prepareStatement(query); 
			ps.setInt(1, id); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				item = new MenuItem( 
						rs.getInt("item_id"),
						rs.getInt("restaurant_id"), 
						rs.getString("item_name"),
						rs.getDouble("price"),
						rs.getBoolean("is_available") 
						); 
				}
			}
		catch (Exception e) { 
			e.printStackTrace(); 
			} 
		finally {
			try {
				con.close(); 
				}
			catch (SQLException e) {
				e.printStackTrace();
				} 
			}
		return item;
	}

	@Override
	public List<MenuItem> getMenuItemsByRestaurant(int restaurantId) {
		List<MenuItem> items = new ArrayList<>(); 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password); 
			query = "SELECT * FROM menu_items WHERE restaurant_id=?";
			ps = con.prepareStatement(query); 
			ps.setInt(1, restaurantId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				MenuItem item = new MenuItem(
						rs.getInt("item_id"),
						rs.getInt("restaurant_id"),
						rs.getString("item_name"), 
						rs.getDouble("price"),
						rs.getBoolean("is_available") );
				items.add(item);
				}
			}
		catch (Exception e) {
			e.printStackTrace(); 
			}
		finally { 
			try { 
				con.close(); 
				}
			catch (SQLException e) {
				e.printStackTrace(); 
				}
			}
		return items; 
	}

	@Override
	public List<MenuItem> getAllMenuItems() {
		List<MenuItem> items = new ArrayList<>();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			query = "SELECT * FROM menu_items"; 
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				MenuItem item = new MenuItem(
						rs.getInt("item_id"),
						rs.getInt("restaurant_id"),
						rs.getString("item_name"), 
						rs.getDouble("price"),
						rs.getBoolean("is_available") );
				items.add(item); 
				}
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		finally {
			try {
				con.close(); 
				}
			catch (SQLException e) {
				e.printStackTrace(); 
				}
			}
		return items;
	}

}

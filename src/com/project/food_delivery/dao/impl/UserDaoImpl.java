package com.project.food_delivery.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.UserDao;
import com.project.food_delivery.models.User;

public class UserDaoImpl  implements UserDao{
	
	Connection con;
	PreparedStatement ps;
	String query;
	int rowCount;
	boolean response;
	
	String url = "jdbc:mysql://localhost:3306/food_delivery_db";
	String user = "root";
	String password = "Ruk@0702";

	@Override
	public boolean addUser(User u) {
		try { Class.forName("com.mysql.cj.jdbc.Driver"); 
		con = DriverManager.getConnection(url, user, password); 
		
		query = "INSERT INTO users(name,email,phone,address) VALUES(?,?,?,?)"; 
		ps = con.prepareStatement(query); 
		ps.setString(1, u.getName()); 
		ps.setString(2, u.getEmail()); 
		ps.setString(3, u.getPhone());
		ps.setString(4, u.getAddress()); 
		rowCount = ps.executeUpdate(); 
		if (rowCount == 1) response = true; 
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace(); 
			} 
		finally {
			try { 
				con.close(); 
				} 
			catch (SQLException e1) { 
				e1.printStackTrace(); 
				}
			}
		return response; 
		}
	
	@Override
	public boolean updateUser(User u) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password);
			query = "UPDATE users SET name=?, email=?, phone=?, address=? WHERE user_id=?";
			ps = con.prepareStatement(query); 
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPhone());
			ps.setString(4, u.getAddress()); 
			ps.setInt(5, u.getUserId()); 
			rowCount = ps.executeUpdate();
			if (rowCount == 1) response = true;
			} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace(); 
			} 
		finally {
			try {
				con.close(); 
				} 
			catch (SQLException e1) { 
				e1.printStackTrace(); 
				}
			}
		return response;
	}

	@Override
	public boolean deleteUserById(int id) {
		try { Class.forName("com.mysql.cj.jdbc.Driver"); 
		con = DriverManager.getConnection(url, user, password); 
		query = "DELETE FROM users WHERE user_id=?";
		ps = con.prepareStatement(query); 
		ps.setInt(1, id); 
		rowCount = ps.executeUpdate(); 
		if (rowCount == 1) response = true;
		} 
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			} 
		finally { 
			try { 
				con.close(); 
				} 
			catch (SQLException e1) {
				e1.printStackTrace();
				}
			} 
		return response; 
		}

	@Override
	public User getUserById(int id) {
		User u = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password); 
			query = "SELECT * FROM users WHERE user_id=?";
			ps = con.prepareStatement(query); 
			ps.setInt(1, id); 
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				u = new User( rs.getInt("user_id"), 
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("phone"), 
						rs.getString("address"),
						rs.getTimestamp("created_at") 
						);
				}
			}
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace(); 
			}
		finally {
			try {
				con.close();
				}
			catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		return u;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<>(); 
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			query = "SELECT * FROM users";
			ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery(); 
			while (rs.next()) {
				User u = new User( 
						rs.getInt("user_id"),
						rs.getString("name"), 
						rs.getString("email"), 
						rs.getString("phone"),
						rs.getString("address"),
						rs.getTimestamp("created_at") 
						);
				userList.add(u);
				} 
			}
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
			}
		finally{
			try {
				con.close();
				}
			catch (SQLException e1) { e1.printStackTrace();
			}
			}
		return userList;
	}

	@Override
	public User getUserByEmail(String email) {
		User u = null; 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			query = "SELECT * FROM users WHERE email=?";
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User( rs.getInt("user_id"), 
						rs.getString("name"),
						rs.getString("email"),
						rs.getString("phone"),
						rs.getString("address"), 
						rs.getTimestamp("created_at") );
				} 
			}
		catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace(); 
			} 
		finally { 
			try { 
				con.close();
				} 
			catch (SQLException e1) {
				e1.printStackTrace();
				}
			}
		return u;
}
	}

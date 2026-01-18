package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.CartDao;
import com.project.food_delivery.models.Cart;

public class CartDaoImpl implements CartDao{
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";
	@Override
	public boolean createCart(Cart cart) {
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con = DriverManager.getConnection(url, user, password); 
			query = "INSERT INTO cart(user_id) VALUES(?)"; 
			ps = con.prepareStatement(query); 
			ps.setInt(1, cart.getUserId()); 
			rowCount = ps.executeUpdate(); 
			if (rowCount == 1) response = true; 
			} 
		catch (Exception e) {
			e.printStackTrace();
			} 
		finally
		{ 
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
	public Cart getCartByUserId(int userId) {
		 Cart cart = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "SELECT * FROM cart WHERE user_id=?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                cart = new Cart(
	                    rs.getInt("cart_id"),
	                    rs.getInt("user_id")
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
	        return cart;

	}
	@Override
	public List<Cart> getAllCarts() {
		   List<Cart> carts = new ArrayList<>();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "SELECT * FROM cart";
	            ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Cart cart = new Cart(
	                    rs.getInt("cart_id"),
	                    rs.getInt("user_id")
	                );
	                carts.add(cart);
	            }

	        } catch (Exception e) { 
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
	        return carts;

	}
	@Override
	public boolean deleteCart(int cartId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM cart WHERE cart_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cartId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { 
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

}

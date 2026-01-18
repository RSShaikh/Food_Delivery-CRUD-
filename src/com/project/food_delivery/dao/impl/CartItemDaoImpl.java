package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.CartItemDao;
import com.project.food_delivery.models.CartItem;

public class CartItemDaoImpl implements CartItemDao {

	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";
	@Override
	public boolean addCartItem(CartItem item) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "INSERT INTO cart_items(cart_id, item_id, quantity) VALUES(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, item.getCartId());
            ps.setInt(2, item.getItemId());
            ps.setInt(3, item.getQuantity());

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
	@Override
	public boolean updateCartItem(CartItem item) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "UPDATE cart_items SET cart_id=?, item_id=?, quantity=? WHERE cart_item_id=?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, item.getCartId());
	            ps.setInt(2, item.getItemId());
	            ps.setInt(3, item.getQuantity());
	            ps.setInt(4, item.getCartItemId());

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}
	@Override
	public boolean deleteCartItem(int cartItemId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM cart_items WHERE cart_item_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cartItemId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;

	}
	@Override
	public List<CartItem> getItemsByCartId(int cartId) {
		List<CartItem> items = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM cart_items WHERE cart_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cartId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem item = new CartItem(
                    rs.getInt("cart_item_id"),
                    rs.getInt("cart_id"),
                    rs.getInt("item_id"),
                    rs.getInt("quantity")
                );
                items.add(item);
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return items;
    }

	@Override
	public CartItem getCartItemById(int cartItemId) {
		CartItem item = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM cart_items WHERE cart_item_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cartItemId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item = new CartItem(
                    rs.getInt("cart_item_id"),
                    rs.getInt("cart_id"),
                    rs.getInt("item_id"),
                    rs.getInt("quantity")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return item;

	}
}

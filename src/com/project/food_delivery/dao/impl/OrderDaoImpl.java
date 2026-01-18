package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.OrderDao;
import com.project.food_delivery.models.Order;

public class OrderDaoImpl implements OrderDao {
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";

	@Override
	public boolean placeOrder(Order order) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "INSERT INTO orders(user_id, restaurant_id, total_amount, order_status) VALUES(?,?,?,?)";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, order.getUserId());
	            ps.setInt(2, order.getRestaurantId());
	            ps.setDouble(3, order.getTotalAmount());
	            ps.setString(4, order.getOrderStatus());

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}

	@Override
	public Order getOrderById(int orderId) {
		Order order = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM orders WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                order = new Order(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getInt("restaurant_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("order_status"),
                    rs.getTimestamp("order_date")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return order;

	}

	@Override
	public List<Order> getOrdersByUser(int userId) {
		List<Order> orders = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM orders WHERE user_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getInt("restaurant_id"),
                    rs.getDouble("total_amount"),
                    rs.getString("order_status"),
                    rs.getTimestamp("order_date")
                );
                orders.add(order);
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return orders;

	}

	@Override
	public List<Order> getAllOrders() {
		 List<Order> orders = new ArrayList<>();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "SELECT * FROM orders";
	            ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Order order = new Order(
	                    rs.getInt("order_id"),
	                    rs.getInt("user_id"),
	                    rs.getInt("restaurant_id"),
	                    rs.getDouble("total_amount"),
	                    rs.getString("order_status"),
	                    rs.getTimestamp("order_date")
	                );
	                orders.add(order);
	            }

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return orders;

	}

	@Override
	public boolean updateOrderStatus(int orderId, String newStatus) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "UPDATE orders SET order_status=? WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, newStatus);
            ps.setInt(2, orderId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;

	}

	@Override
	public boolean deleteOrder(int orderId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM orders WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;
    }

}

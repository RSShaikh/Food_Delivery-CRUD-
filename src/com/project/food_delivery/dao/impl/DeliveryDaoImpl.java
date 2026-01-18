package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.DeliveryDao;
import com.project.food_delivery.models.Delivery;

public class DeliveryDaoImpl implements DeliveryDao{
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";
	
	@Override
	public boolean assignDelivery(Delivery delivery) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "INSERT INTO delivery(order_id, agent_id, delivery_status) VALUES(?,?,?)";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, delivery.getOrderId());
	            ps.setInt(2, delivery.getAgentId());
	            ps.setString(3, delivery.getDeliveryStatus());

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}
	@Override
	public Delivery getDeliveryByOrderId(int orderId) {
		 Delivery delivery = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "SELECT * FROM delivery WHERE order_id=?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, orderId);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                delivery = new Delivery(
	                    rs.getInt("delivery_id"),
	                    rs.getInt("order_id"),
	                    rs.getInt("agent_id"),
	                    rs.getString("delivery_status"),
	                    rs.getTimestamp("delivered_time")
	                );
	            }

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return delivery;

	}
	@Override
	public Delivery getDeliveryById(int deliveryId) {
		Delivery delivery = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM delivery WHERE delivery_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, deliveryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                delivery = new Delivery(
                    rs.getInt("delivery_id"),
                    rs.getInt("order_id"),
                    rs.getInt("agent_id"),
                    rs.getString("delivery_status"),
                    rs.getTimestamp("delivered_time")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return delivery;

	}
	@Override
	public List<Delivery> getAllDeliveries() {
		 List<Delivery> deliveries = new ArrayList<>();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "SELECT * FROM delivery";
	            ps = con.prepareStatement(query);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Delivery delivery = new Delivery(
	                    rs.getInt("delivery_id"),
	                    rs.getInt("order_id"),
	                    rs.getInt("agent_id"),
	                    rs.getString("delivery_status"),
	                    rs.getTimestamp("delivered_time")
	                );
	                deliveries.add(delivery);
	            }

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return deliveries;

	}
	@Override
	public boolean updateDeliveryStatus(int deliveryId, String newStatus) {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(url, user, password);

	        if (newStatus.equalsIgnoreCase("Delivered")) {
	            query = "UPDATE delivery SET delivery_status=?, delivered_time=CURRENT_TIMESTAMP WHERE delivery_id=?";
	        } else {
	            query = "UPDATE delivery SET delivery_status=? WHERE delivery_id=?";
	        }

	        ps = con.prepareStatement(query);
	        ps.setString(1, newStatus);
	        ps.setInt(2, deliveryId);

	        rowCount = ps.executeUpdate();
	        if (rowCount == 1) response = true;

	    } catch (Exception e) { e.printStackTrace(); }
	    finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	    return response;
	}

	@Override
	public boolean markDelivered(int deliveryId) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "UPDATE delivery SET delivery_status='Delivered', delivered_time=NOW() WHERE delivery_id=?";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, deliveryId);

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}
	@Override
	public boolean deleteDelivery(int deliveryId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM delivery WHERE delivery_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, deliveryId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;
    }
}

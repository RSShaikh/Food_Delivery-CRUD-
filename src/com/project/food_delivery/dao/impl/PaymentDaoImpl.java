package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.PaymentDao;
import com.project.food_delivery.models.Payment;

public class PaymentDaoImpl implements PaymentDao {
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";

	@Override
	public boolean addPayment(Payment payment) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "INSERT INTO payments(order_id, amount, payment_method, payment_status) VALUES(?,?,?,?)";
	            ps = con.prepareStatement(query);
	            ps.setInt(1, payment.getOrderId());
	            ps.setDouble(2, payment.getAmount());
	            ps.setString(3, payment.getPaymentMethod());
	            ps.setString(4, payment.getPaymentStatus());

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}

	@Override
	public Payment getPaymentById(int paymentId) {
		Payment payment = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM payments WHERE payment_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, paymentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                payment = new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("order_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status"),
                    rs.getTimestamp("payment_date")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return payment;

	}

	@Override
	public Payment getPaymentByOrderId(int orderId) {
		Payment payment = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM payments WHERE order_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                payment = new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("order_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status"),
                    rs.getTimestamp("payment_date")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return payment;

	}

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> payments = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM payments";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Payment payment = new Payment(
                    rs.getInt("payment_id"),
                    rs.getInt("order_id"),
                    rs.getDouble("amount"),
                    rs.getString("payment_method"),
                    rs.getString("payment_status"),
                    rs.getTimestamp("payment_date")
                );
                payments.add(payment);
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return payments;

	}

	@Override
	public boolean updatePaymentStatus(int paymentId, String newStatus) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "UPDATE payments SET payment_status=? WHERE payment_id=?";
	            ps = con.prepareStatement(query);
	            ps.setString(1, newStatus);
	            ps.setInt(2, paymentId);

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}

	@Override
	public boolean deletePayment(int paymentId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM payments WHERE payment_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, paymentId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;
    }

}

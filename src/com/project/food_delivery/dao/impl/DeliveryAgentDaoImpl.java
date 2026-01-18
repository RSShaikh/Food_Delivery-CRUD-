package com.project.food_delivery.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.food_delivery.dao.DeliveryAgentDao;
import com.project.food_delivery.models.DeliveryAgent;

public class DeliveryAgentDaoImpl implements DeliveryAgentDao{
	
	Connection con;
	PreparedStatement ps;
	String query; 
	int rowCount; 
	boolean response; 
	String url = "jdbc:mysql://localhost:3306/food_delivery_db"; 
	String user = "root";
	String password = "Ruk@0702";

	@Override
	public boolean addAgent(DeliveryAgent agent) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "INSERT INTO delivery_agents(name, phone, is_available) VALUES(?,?,?)";
	            ps = con.prepareStatement(query);
	            ps.setString(1, agent.getName());
	            ps.setString(2, agent.getPhone());
	            ps.setBoolean(3, agent.isAvailable());

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;

	}

	@Override
	public boolean updateAgent(DeliveryAgent agent) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "UPDATE delivery_agents SET name=?, phone=?, is_available=? WHERE agent_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, agent.getName());
            ps.setString(2, agent.getPhone());
            ps.setBoolean(3, agent.isAvailable());
            ps.setInt(4, agent.getAgentId());

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;

	}

	@Override
	public boolean deleteAgent(int agentId) {
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM delivery_agents WHERE agent_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, agentId);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return response;

	}

	@Override
	public DeliveryAgent getAgentById(int agentId) {
		DeliveryAgent agent = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM delivery_agents WHERE agent_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, agentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                agent = new DeliveryAgent(
                    rs.getInt("agent_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getBoolean("is_available")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return agent;

	}

	@Override
	public List<DeliveryAgent> getAllAgents() {
		List<DeliveryAgent> agents = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM delivery_agents";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DeliveryAgent agent = new DeliveryAgent(
                    rs.getInt("agent_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getBoolean("is_available")
                );
                agents.add(agent);
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return agents;

	}

	@Override
	public List<DeliveryAgent> getAvailableAgents() {
		List<DeliveryAgent> agents = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM delivery_agents WHERE is_available=1";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DeliveryAgent agent = new DeliveryAgent(
                    rs.getInt("agent_id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getBoolean("is_available")
                );
                agents.add(agent);
            }

        } catch (Exception e) { e.printStackTrace(); }
        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
        return agents;

	}

	@Override
	public boolean updateAvailability(int agentId, boolean isAvailable) {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);

	            query = "UPDATE delivery_agents SET is_available=? WHERE agent_id=?";
	            ps = con.prepareStatement(query);
	            ps.setBoolean(1, isAvailable);
	            ps.setInt(2, agentId);

	            rowCount = ps.executeUpdate();
	            if (rowCount == 1) response = true;

	        } catch (Exception e) { e.printStackTrace(); }
	        finally { try { con.close(); } catch (SQLException e) { e.printStackTrace(); } }
	        return response;
	    }

}

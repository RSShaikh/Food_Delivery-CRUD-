package com.project.food_delivery.dao.impl;

import com.project.food_delivery.dao.RestaurantDao;
import com.project.food_delivery.models.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {

    Connection con;
    PreparedStatement ps;
    String query;
    int rowCount;
    boolean response;

    String url = "jdbc:mysql://localhost:3306/food_delivery_db";
    String user = "root";
    String password = "Ruk@0702";

    @Override
    public boolean addRestaurant(Restaurant r) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "INSERT INTO restaurants(name, address, rating, is_active) VALUES(?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setDouble(3, r.getRating());
            ps.setBoolean(4, r.isActive());

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return response;
    }

    @Override
    public boolean updateRestaurant(Restaurant r) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "UPDATE restaurants SET name=?, address=?, rating=?, is_active=? WHERE restaurant_id=?";
            ps = con.prepareStatement(query);
            ps.setString(1, r.getName());
            ps.setString(2, r.getAddress());
            ps.setDouble(3, r.getRating());
            ps.setBoolean(4, r.isActive());
            ps.setInt(5, r.getRestaurantId());

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return response;
    }

    @Override
    public boolean deleteRestaurantById(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "DELETE FROM restaurants WHERE restaurant_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rowCount = ps.executeUpdate();
            if (rowCount == 1) response = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return response;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant r = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM restaurants WHERE restaurant_id=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                r = new Restaurant(
                    rs.getInt("restaurant_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDouble("rating"),
                    rs.getBoolean("is_active")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return r;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            query = "SELECT * FROM restaurants";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Restaurant r = new Restaurant(
                    rs.getInt("restaurant_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getDouble("rating"),
                    rs.getBoolean("is_active")
                );
                restaurantList.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return restaurantList;
    }
}

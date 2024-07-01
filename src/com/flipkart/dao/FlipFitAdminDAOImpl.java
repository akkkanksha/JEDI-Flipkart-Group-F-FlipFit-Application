package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDAOImpl implements  IFlipFitAdminDAO {
    @Override
    public boolean adminLogin(FlipFitAdmin adminUser) {
        String sql = "SELECT * FROM GymAdmin WHERE adminID = ? AND password = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, adminUser.getUserID());
            stmt.setString(2, adminUser.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // If there's a result, login is successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<FlipFitGymOwner> getPendingOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT * FROM GymOwner WHERE approved = 0";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserID(rs.getInt("ownerID"));
                owner.setAadharNumber(rs.getString("Aadhar"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingOwners;
    }

    @Override
    public List<FlipFitGymCustomer> getUserList() {
        List<FlipFitGymCustomer> users = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Assuming you have a User class
                FlipFitGymCustomer user = new FlipFitGymCustomer(); // Replace with actual User class
                user.setUserID(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean validateOwner(int ownerId) {
        String sql = "UPDATE GymOwner SET approved = 1 WHERE ownerID = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteOwner(int ownerId) {
        String sql = "DELETE FROM GymOwner WHERE ownerID = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

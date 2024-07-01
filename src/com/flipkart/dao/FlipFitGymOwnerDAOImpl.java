package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.interfaces.IFlipFitGymOwnerDAO;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.FlipFitUser;

public class FlipFitGymOwnerDAOImpl implements IFlipFitGymOwnerDAO {
    Random rand = new Random();
    @Override
    public FlipFitGymCentre addCentre(FlipFitGymCentre centre) {
        String sql = "INSERT INTO GymCentre (ownerID, capacity, approved, city, state, pincode) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, centre.getOwnerID());
            stmt.setInt(2, centre.getCapacity());
            stmt.setBoolean(3, centre.isApproved());
            stmt.setString(4, centre.getCity());
            stmt.setString(5, centre.getState());
            stmt.setString(6, centre.getPincode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating centre failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int centreID = generatedKeys.getInt(1);
                    centre.setCentreID(centreID);
                } else {
                    throw new SQLException("Creating centre failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centre;
    }

    @Override
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner owner) {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        int userId = owner.getUserId();
        String sql = "SELECT centreID, ownerID, capacity, city, state, pincode FROM GymCentre where ownerID=?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setState(rs.getString("state"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

//    @Override
//    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre) {
//        List<FlipFitUser> flipfitusers = new ArrayList<>();
//        String sql = "SELECT * from Booking where userID = ? and isDeleted = false";
//        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
//            stmt.setInt(1, centre.getOwnerID());
//            ResultSet rs = stmt.executeQuery();
//            while (rs.next()) {
//                FlipFitUser flipfituser = new FlipFitUser();
//                flipfituser.setUserID(rs.getInt("userID"));
//                flipfitusers.add(flipfituser);
//            }
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return flipfitusers;
//   }




    @Override
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner) {
        int userId = owner.getUserId();
        String sql = "UPDATE GymOwner SET PAN=?, Aadhar=? ,GSTIN=? WHERE ownerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, owner.getPanId());
            stmt.setString(2, owner.getAadharNumber());
            stmt.setString(3,owner.getGSTNum());
            stmt.setInt(4, userId);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    return owner;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public FlipFitUser addUser(FlipFitUser user) {
        String sql = "INSERT INTO User (userName, roleID, emailID, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUserName());
            stmt.setInt(2, user.getRoleID());
            stmt.setString(3, user.getEmailID());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    user.setUserID(userID);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public FlipFitGymOwner addGymOwner(FlipFitGymOwner owner, FlipFitUser user) {
        String sql = "INSERT INTO GymOwner (ownerID ,PAN, Aadhar, GSTIN, approved) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserID());
            stmt.setString(2, owner.getPanId());
            stmt.setString(3, owner.getAadharNumber());
            stmt.setString(4, owner.getGSTNum());
            stmt.setBoolean(5, false);
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating owner failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        owner.setUserId(user.getUserID());
        return owner;
    }


}
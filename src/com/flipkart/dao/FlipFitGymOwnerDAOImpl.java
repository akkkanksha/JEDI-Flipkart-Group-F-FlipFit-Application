package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.IFlipFitGymOwnerDAO;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.FlipFitUser;

public class FlipFitGymOwnerDAOImpl implements IFlipFitGymOwnerDAO {
    Random rand = new Random();
    @Override
    public boolean addCentre(FlipFitGymCentre centre) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO GymCentre VALUES (?, ?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            centre.setCentreID(rand.nextInt(1000));
            stmt.setInt(1, centre.getCentreID());
            stmt.setInt(2, centre.getOwnerID());
            stmt.setInt(3, centre.getCapacity());
            stmt.setBoolean(4, centre.isApproved());
            stmt.setString(5, centre.getCity());
            stmt.setString(6, centre.getState());
            stmt.setString(7, centre.getPincode());

            int i = stmt.executeUpdate();
            System.out.println(i + " user added");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner) {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT centreID, ownerID, capacity FROM GymCentre where ownerID=owner.userID";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

    @Override
    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre) {
        List<FlipFitUser> flipfitusers = new ArrayList<>();
        String sql = "SELECT userID from Booking where userID = centre.centreID";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitUser flipfituser = new FlipFitUser();
                flipfituser.setUserID(rs.getInt("userID"));
                flipfitusers.add(flipfituser);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return flipfitusers;
    }


    @Override
    public boolean editDetails(FlipFitGymOwner owner) {
        String sql = "UPDATE GymOwner SET PAN=?, Aadhar=? ,GSTIN=? WHERE ownerID=owner.userId";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, owner.getPanId());
            stmt.setString(2, owner.getAadharNumber());
            stmt.setString(3,owner.getGSTNum());
            ResultSet rs = stmt.executeQuery();
            if(rs!=null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }
}
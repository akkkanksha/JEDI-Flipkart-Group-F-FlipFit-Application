package com.flipkart.dao;
import java.sql.*;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.IFlipFitGymOwnerDAO;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import com.flipkart.bean.FlipFitUser;

public class FlipFitGymOwnerDAOImpl implements IFlipFitGymOwnerDAO {
    Random rand = new Random();

    @Override
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner) {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT centreID, capacity, city FROM GymCentre where ownerID=?");

            stmt.setInt(1, owner.getUserId());
//
//        String sql = "SELECT centreID, ownerID, capacity FROM GymCentre where ownerID=this.userID";
//        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentres.add(gymcentre);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return gymcentres;
    }

    @Override
    public List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre) {
        List<FlipFitUser> flipfitusers = new ArrayList<>();
        String sql = "SELECT userID from Booking where userID = ?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, centre.getOwnerID());
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
            stmt.setString(1, owner.getPAN());
            stmt.setString(2, owner.getAadharNumber());
            stmt.setString(3,owner.getGSTIN());
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
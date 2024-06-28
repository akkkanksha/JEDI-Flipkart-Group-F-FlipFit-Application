package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.dao.interfaces.IFlipFitGymCustomerDAO;

import java.util.*;
import java.sql.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO {

    @Override
    public List<FlipFitSlots> viewBookedSlots(int userID) {
        List<FlipFitSlots> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID = ? and isDeleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slotID"));
                bookedSlots.add(slot);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookedSlots;
    }

    @Override
    public boolean checkBookingConflicts(int userID, int slotID) {
        String sql = "SELECT * FROM Booking WHERE userID = ? and slotID = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            stmt.setInt(2, slotID);
            ResultSet rs = stmt.executeQuery();
            if(rs!=null) {
                return true; // there is a conflict
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<FlipFitGymCentre> viewCentres() {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT centreID, ownerID, capacity FROM GymCentre";
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
    public boolean makePayment(int userID) {
        return false;
    }

    @Override
    public void viewPaymentDetails(int userID) {

    }

    @Override
    public void editPaymentDetails(int userID) {

    }

    @Override
    public boolean editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE Customer SET city=?, pincode=? WHERE customerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs!=null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "UPDATE User SET userName=?, password=? WHERE userID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getPassword());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs!=null) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String args[]){
        FlipFitUser FFU = new FlipFitUser();

        FFU.setUserName("PP");
        FFU.setPassword("pp2");
        FFU.setRoleID(1);
        FFU.setEmailID("pp@mail");
        FFU.setPhoneNumber("9800756987");
        FFU.setUserID(1);


        FlipFitUser FFU1 = new FlipFitUser();

        FFU1.setUserName("PP1");
        FFU1.setPassword("pp21");
        FFU1.setRoleID(11);
        FFU1.setEmailID("pp1@mail");
        FFU1.setPhoneNumber("98007569871");
        FFU1.setUserID(2);

//        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();
//        FFUDAO.addUser(FFU);
//        FFUDAO.addUser(FFU1);


        FlipFitGymCustomerDAOImpl FFGCDAO = new FlipFitGymCustomerDAOImpl();
        List<FlipFitSlots> slots=FFGCDAO.viewBookedSlots(FFU.getUserID());
        for(FlipFitSlots slot : slots){
            System.out.println(slot.getSlotId());
        }






    }
}
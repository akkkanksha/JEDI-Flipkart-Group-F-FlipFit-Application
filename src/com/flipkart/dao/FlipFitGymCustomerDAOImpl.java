package com.flipkart.dao;

import com.flipkart.bean.*;
import com.flipkart.dao.interfaces.IFlipFitGymCustomerDAO;

import java.util.*;
import java.sql.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO {

    @Override
    public List<FlipFitBooking> viewBookedSlots(int userID) {
        List<FlipFitBooking> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID = ? and isDeleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitBooking booking = new FlipFitBooking();
                booking.setBookingId(rs.getInt("bookingID"));
                bookedSlots.add(booking);
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
            if(rs.next()) {
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
        String sql = "SELECT centreID, ownerID, capacity, city FROM GymCentre";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
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
    public List<FlipFitPayments> viewPaymentDetails(int userID) {
        FlipFitPaymentsDAOImpl FFPDAO = new FlipFitPaymentsDAOImpl();
        return FFPDAO.viewPaymentInfo(userID);
    }

    @Override
    public void editPaymentDetails(FlipFitPayments FFP) {
        // add payment info
        FlipFitPaymentsDAOImpl FFPDAO = new FlipFitPaymentsDAOImpl();
        FFPDAO.setPaymentInfo(FFP);
    }

    @Override
    public boolean editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE Customer SET city=?, pincode=? WHERE customerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3,customer.getUserId());
            int i = stmt.executeUpdate();
            if (i > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
package com.flipkart.dao;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import java.sql.*;
import com.flipkart.bean.FlipFitBooking;
import java.sql.PreparedStatement;
import com.flipkart.constant.DBConstants;

import java.util.ArrayList;
import java.util.List;

public class FlipFitBookingDAOImpl implements IFlipFitBookingDAO {
    @Override
    public void makeBooking(FlipFitBooking booking) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Booking VALUES (?, ?, ?)");
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getSlotId());
            stmt.setBoolean(3, booking.isdeleted());

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public boolean deleteBooking(int bookingId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Booking WHERE id = ?");
            stmt.setInt(1, bookingId);

            int i = stmt.executeUpdate();
            System.out.println(i + " records deleted");

            con.close();

            return true;

        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

//    @Override
    public List<FlipFitBooking> getAllBookings(int userId) {
        List<FlipFitBooking> bookings = new ArrayList<FlipFitBooking>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Booking WHERE userId = ?");
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int UserId = rs.getInt("userID");
                int slotId = rs.getInt("slotID");
                boolean isdeleted = rs.getBoolean("isdeleted");

                FlipFitBooking booking = new FlipFitBooking();
                booking.setUserId(UserId);
                booking.setSlotId(slotId);
                booking.setIsdeleted(isdeleted);

                bookings.add(booking);
            }

            con.close();
            return bookings;
        } catch (SQLException e) {
            System.out.println("Error retrieving bookings: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

}
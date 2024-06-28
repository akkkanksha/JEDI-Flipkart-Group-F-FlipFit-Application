package com.flipkart.dao;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import java.sql.*;
import com.flipkart.bean.FlipFitBooking;
import java.sql.PreparedStatement;
import com.flipkart.constant.DBConstants;

import java.util.ArrayList;
import java.util.List;

public class FlipFitBookingDAOImpl implements IFlipFitBookingDAO {

        public static void main(String[] args) {

            IFlipFitBookingDAO bookingDAO = new FlipFitBookingDAOImpl();

            FlipFitBooking newBooking = new FlipFitBooking();
            newBooking.setUserId(101);
            newBooking.setSlotId(5);
            newBooking.setIsdeleted(false);

            //Connection con = GetConnection.getConnection();

            System.out.println("Making a new booking:");
            bookingDAO.makeBooking(newBooking);


            int userIdToGet = 101;

            System.out.println("\nGet all bookings for user ID: " + userIdToGet);
            List<FlipFitBooking> bookings = bookingDAO.getAllBookings(userIdToGet);
            for (FlipFitBooking booking : bookings) {
                System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isdeleted());
            }

            int bookingIdToDelete = 1;
            System.out.println("\nDeleting booking with ID: " + bookingIdToDelete);
            boolean deleteSuccess = bookingDAO.deleteBooking(bookingIdToDelete);
            System.out.println("Booking deletion successful: " + deleteSuccess);

            bookingDAO = new FlipFitBookingDAOImpl();

            int bookingIdToGet = 1;
            System.out.println("Get booking details for booking ID: " + bookingIdToGet);
            List<FlipFitBooking> bookingDetails = bookingDAO.getBookingDetails(bookingIdToGet);
            for (FlipFitBooking booking : bookingDetails) {
                System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isdeleted());
            }
        }

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

    @Override
    public List<FlipFitBooking> getAllBookings(int userId) {
        List<FlipFitBooking> bookings = new ArrayList<>(); // Initialize the list to an empty list

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
        } catch (SQLException e) {
            System.out.println("Error getting all bookings: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return bookings; // Always return the list, even if it's empty
    }

    @Override
    public List getBookingDetails(int bookingId) {
        List bookings = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Booking WHERE id = ?");
            stmt.setInt(1, bookingId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int UserId = rs.getInt("userId");
                int SlotId = rs.getInt("slotId");
                boolean IsDeleted = rs.getBoolean("isdeleted");

                FlipFitBooking booking = new FlipFitBooking();
                booking.setUserId(UserId);
                booking.setSlotId(SlotId);
                booking.setIsdeleted(IsDeleted);

                bookings.add(booking);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error getting booking details: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }
    public FlipFitBooking getBookingDetailsByBookingId(int bookingId) {
        FlipFitBooking booking = null;
        String sql = "SELECT * FROM Booking WHERE bookingID = ?";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookingId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    booking = new FlipFitBooking();
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setSlotTime(rs.getInt("slotTime"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }
}
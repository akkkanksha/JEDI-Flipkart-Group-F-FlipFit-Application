package com.flipkart.dao;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import java.sql.*;
import com.flipkart.bean.FlipFitBooking;
import java.sql.PreparedStatement;
import com.flipkart.constant.DBConstants;

import java.util.ArrayList;
import java.util.List;

public class FlipFitBookingDAOImpl implements IFlipFitBookingDAO {

//        public static void main(String[] args) {
//
//            IFlipFitBookingDAO bookingDAO = new FlipFitBookingDAOImpl();
//
//            FlipFitBooking newBooking = new FlipFitBooking();
//            newBooking.setUserId(101);
//            newBooking.setSlotId(5);
//            newBooking.setIsdeleted(false);
//
//            //Connection con = GetConnection.getConnection();
//
//            System.out.println("Making a new booking:");
//            bookingDAO.makeBooking(newBooking);
//
//
//            int userIdToGet = 101;
//
//            System.out.println("\nGet all bookings for user ID: " + userIdToGet);
//            List<FlipFitBooking> bookings = bookingDAO.getAllBookings(userIdToGet);
//            for (FlipFitBooking booking : bookings) {
//                System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isdeleted());
//            }
//
//            int bookingIdToDelete = 1;
//            System.out.println("\nDeleting booking with ID: " + bookingIdToDelete);
//            boolean deleteSuccess = bookingDAO.deleteBooking(bookingIdToDelete);
//            System.out.println("Booking deletion successful: " + deleteSuccess);
//
//            bookingDAO = new FlipFitBookingDAOImpl();
//
//            int bookingIdToGet = 1;
//            System.out.println("Get booking details for booking ID: " + bookingIdToGet);
//            List<FlipFitBooking> bookingDetails = bookingDAO.getBookingDetails(bookingIdToGet);
//            for (FlipFitBooking booking : bookingDetails) {
//                System.out.println("Booking ID: " + booking.getUserId() + ", Slot ID: " + booking.getSlotId() + ", Is Deleted: " + booking.isdeleted());
//            }
//        }

    @Override
    public FlipFitBooking makeBooking(FlipFitBooking booking) {
        String sql = "INSERT INTO Booking (userID, slotTime, slotID, isDeleted) VALUES (?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getSlotTime());
            stmt.setInt(3, booking.getSlotId());
            stmt.setBoolean(4, false);

            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating booking failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int bookingID = generatedKeys.getInt(1);
                    booking.setBookingId(bookingID);
                    booking.setIsdeleted(false);
                } else {
                    throw new SQLException("Creating booking failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    @Override
    public boolean deleteBooking(int bookingId) {
        String sql = "DELETE FROM Booking WHERE bookingID = ?";
        try(Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, bookingId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Deleting booking failed, no rows affected.");
            }
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FlipFitBooking> getAllBookings(int userId) {
        List<FlipFitBooking> bookings = new ArrayList<>(); // Initialize the list to an empty list

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Booking WHERE userID = ?");
            stmt.setInt(1, userId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int UserId = rs.getInt("userID");
                int slotId = rs.getInt("slotID");
                int bookingId = rs.getInt("bookingID");
                boolean isdeleted = rs.getBoolean("isdeleted");

                FlipFitBooking booking = new FlipFitBooking();
                booking.setUserId(UserId);
                booking.setSlotId(slotId);
                booking.setIsdeleted(isdeleted);
                booking.setBookingId(bookingId);

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
                    return booking;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
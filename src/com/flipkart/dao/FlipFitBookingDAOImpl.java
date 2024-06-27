package com.flipkart.dao;
import com.flipkart.dao.interfaces.IFlipFitBookingDAO;
import java.sql.*;
import com.flipkart.bean.FlipFitBooking;
import com.flipkart.dao.GetConnection;
public class FlipFitBookingDAOImpl implements IFlipFitBookingDAO {
    @Override
    public void makeBooking(FlipFitBooking booking) {
        try {
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Booking VALUES (?, ?, ?)");
            stmt.setInt(1, booking.getUserId());
            stmt.setInt(2, booking.getSlotId());
            stmt.setBoolean(3,booking.isdeleted());

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
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Booking WHERE id =  values(?, ?, ?)");
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

}


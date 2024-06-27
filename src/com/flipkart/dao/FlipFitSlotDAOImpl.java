package com.flipkart.dao;
import com.flipkart.dao.interfaces.*;
import java.sql.*;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.constant.DBConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotDAOImpl implements IFlipFitSlotDAO {
    @Override
    public boolean addSlot(FlipFitSlots slot) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Slot (slotId, centerId, startTime, seatsAvailable) VALUES (?, ?, ?, ?)");

            stmt.setInt(1, slot.getSlotId());
            stmt.setInt(2, slot.getCentreId());
            stmt.setLong(3, slot.getSlotTime());
            stmt.setInt(4, slot.getSeatsAvailable());
            int i = stmt.executeUpdate();
            System.out.println(i + " slot added");
            con.close();

            return i>0;

        } catch (Exception e) {
            System.out.println("Error adding slot: " + e);
        }
        return false; // Return false if deletion failed
    }


    @Override
    public boolean deleteSlot(int slotID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Slot WHERE slotId = ?");

            stmt.setInt(1, slotID);

            int i = stmt.executeUpdate();
            System.out.println(i + " slot deleted");

            // Close the connection
            con.close();

            return i > 0;

        } catch (Exception e) {
            System.out.println("Error deleting slot: " + e);
        }
        return false;
    }

    @Override
    public boolean changeSlot(FlipFitSlots slot) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("UPDATE Slot SET centerId = ?, startTime = ?, seatsAvailable = ? WHERE slotId = ?");

            stmt.setInt(1, slot.getCentreId());
            stmt.setLong(2, slot.getSlotTime());
            stmt.setInt(3, slot.getSeatsAvailable());
            stmt.setInt(4, slot.getSlotId());

            int i = stmt.executeUpdate();
            System.out.println(i + " slot updated");

            con.close();

            return i > 0;

        } catch (Exception e) {
            System.out.println("Error updating slot: " + e);
        }

        return false;
    }

    @Override
    public List<FlipFitSlots> getAllSlots(int CenterID) {
        List<FlipFitSlots> slots = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slot WHERE centerId = ?");
            stmt.setInt(1, CenterID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int slotID = rs.getInt("slotId");
                int centerID = rs.getInt("centerId");
                long StartTime = rs.getLong("startTime");
                int SeatsAvailable = rs.getInt("seatsAvailable");

                FlipFitSlots slot = new FlipFitSlots();
                slots.add(slot);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error retrieving slots: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return slots;
    }
    public FlipFitSlots getSlotDetailsById(int slotId){
        return new FlipFitSlots();
    }
}
package com.flipkart.dao;
import com.flipkart.dao.interfaces.*;
import java.sql.*;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.constant.DBConstants;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FlipFitSlotDAOImpl implements IFlipFitSlotDAO {
    Random rand = new Random();

    @Override
    public boolean addSlot(FlipFitSlots slot) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Slots VALUES (?, ?, ?, ?)");

            slot.setSlotId(rand.nextInt(1000));
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

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Slots WHERE slotId = ?");

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

            PreparedStatement stmt = con.prepareStatement("UPDATE Slots SET centreID = ?, slotTime = ?, seatsAvailable = ? WHERE slotID = ?");

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
    public List<FlipFitSlots> getAllSlots(int centreID) {
        List<FlipFitSlots> slots = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE centreID = ?");
            stmt.setInt(1, centreID);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slotId"));
                slot.setCentreId(rs.getInt("centreId"));
                slot.setSlotTime(rs.getLong("slotTime"));
                slot.setSeatsAvailable(rs.getInt("seatsAvailable"));

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

    @Override
    public FlipFitSlots getSlotDetailsById(int slotId) {
        return null;
    }

    @Override
    public FlipFitSlots getSlotDetails(int slotId) {
        FlipFitSlots slot = new FlipFitSlots();
        try {
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE slotID = ?");
            stmt.setInt(1, slotId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                slot.setSlotId(rs.getInt("slotId"));
                slot.setCentreId(rs.getInt("centreId"));
                slot.setSlotTime(rs.getLong("slotTime"));
                slot.setSeatsAvailable(rs.getInt("seatsAvailable"));
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error retrieving slot details by ID: " + e.getMessage());
        }
        return slot;
    }
}
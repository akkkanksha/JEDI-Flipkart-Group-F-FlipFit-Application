package com.flipkart.dao;
import com.flipkart.dao.interfaces.*;
import java.sql.*;
import com.flipkart.bean.FlipFitSlots;
import com.flipkart.dao.GetConnection;
public class FlipFitSlotDAOImpl implements IFlipFitSlotDAO {
    @Override
    public boolean addSlot(FlipFitSlots slot) {
        try {
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Slot (slotId, centerId, startTime, seatsAvailable) VALUES (?, ?, ?, ?)");

            stmt.setInt(1, slot.getSlotId());
            stmt.setInt(2, slot.getCenterId());
            stmt.setLong(3, slot.getStartTime());
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
            Connection con = GetConnection.getConnection();

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
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("UPDATE Slot SET centerId = ?, startTime = ?, seatsAvailable = ? WHERE slotId = ?");

            stmt.setInt(1, slot.getCenterId());
            stmt.setLong(2, slot.getStartTime());
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
}
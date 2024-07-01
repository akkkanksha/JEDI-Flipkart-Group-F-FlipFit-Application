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
//    public static void main(String[] args) {
//        IFlipFitSlotDAO slotDAO = new FlipFitSlotDAOImpl();
//
//        FlipFitSlots newSlot = new FlipFitSlots();
//        newSlot.setSlotId(1);
//        newSlot.setCentreId(101);
//        newSlot.setSlotTime(8);
//        newSlot.setSeatsAvailable(50);
//
//        System.out.println("Adding a new slot:");
//        boolean isAdded = slotDAO.addSlot(newSlot);
//        System.out.println("Slot added: " + isAdded);
//
//        int centerIdToRetrieve = 101;
//        System.out.println("\nRetrieving all slots for center ID: " + centerIdToRetrieve);
//        List<FlipFitSlots> slots = slotDAO.getAllSlots(centerIdToRetrieve);
//        for (FlipFitSlots slot : slots) {
//            System.out.println("Slot ID: " + slot.getSlotId() + ", Center ID: " + slot.getCentreId() +
//                    ", Slot Time: " + slot.getSlotTime() + ", Seats Available: " + slot.getSeatsAvailable());
//        }
//
//        FlipFitSlots slotToUpdate = new FlipFitSlots();
//        slotToUpdate.setSlotId(1);
//        slotToUpdate.setCentreId(102);
//        slotToUpdate.setSlotTime(8);
//        slotToUpdate.setSeatsAvailable(45);
//
//        System.out.println("\nUpdating slot with ID: " + slotToUpdate.getSlotId());
//        boolean isUpdated = slotDAO.changeSlot(slotToUpdate);
//        System.out.println("Slot updated: " + isUpdated);
//
//        int slotIdToDelete = 1;
//        System.out.println("\nDeleting slot with ID: " + slotIdToDelete);
//        boolean isDeleted = slotDAO.deleteSlot(slotIdToDelete);
//        System.out.println("Slot deleted: " + isDeleted);
//
//        int slotIdToGet = 1;
//        int centreIdToRetrieve = 103;
//        System.out.println("\nGet slot details for slot ID: " + slotIdToGet);
//        FlipFitSlots slot = slotDAO.getSlotDetails(slotIdToGet, centreIdToRetrieve);
//
//    }


    @Override
    public FlipFitSlots addSlot(FlipFitSlots slot) {
        String sql = "INSERT INTO Slots (centreID, slotTime, seatsAvailable) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, slot.getCentreId());
            stmt.setInt(2, slot.getSlotTime());
            stmt.setInt(3, slot.getSeatsAvailable());

            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Creating slot failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int slotID = generatedKeys.getInt(1);
                    slot.setSlotId(slotID);
                } else {
                    throw new SQLException("Creating slot failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error adding slot: " + e);
        }
        return slot;
    }


    @Override
    public boolean deleteSlot(int slotID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

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
        String sql = "UPDATE Slots SET centreID = ?, slotTime = ?, seatsAvailable = ? WHERE slotID = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, slot.getCentreId());
            stmt.setInt(2, slot.getSlotTime());
            stmt.setInt(3, slot.getSeatsAvailable());
            stmt.setInt(4, slot.getSlotId());

            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new SQLException("Updating slots failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(
//                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);
//
//            PreparedStatement stmt = con.prepareStatement("UPDATE Slots SET centerId = ?, startTime = ?, seatsAvailable = ? WHERE slotId = ?");
//
//            stmt.setInt(1, slot.getCentreId());
//            stmt.setLong(2, slot.getSlotTime());
//            stmt.setInt(3, slot.getSeatsAvailable());
//            stmt.setInt(4, slot.getSlotId());
//
//            int i = stmt.executeUpdate();
//            System.out.println(i + " slot updated");
//
//            con.close();
//
//            return i > 0;
//
//        } catch (Exception e) {
//            System.out.println("Error updating slot: " + e);
//        }
//
//        return false;
//    }

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
                int slotID = rs.getInt("slotID");
                int StartTime = rs.getInt("slotTime");
                int SeatsAvailable = rs.getInt("seatsAvailable");

                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(slotID);
                slot.setCentreId(centreID);
                slot.setSlotTime(StartTime);
                slot.setSeatsAvailable(SeatsAvailable);
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
        String sql = "SELECT * FROM Slots WHERE slotID=?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, slotId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int slotid = rs.getInt("slotID");
                    int seatsAvailable = rs.getInt("seatsAvailable");
                    int slotTime = rs.getInt("slotTime");
                    int centreID = rs.getInt("centreID");
                    FlipFitSlots slot = new FlipFitSlots();
                    slot.setSlotId(slotid);
                    slot.setSlotTime(slotTime);
                    slot.setSeatsAvailable(seatsAvailable);
                    slot.setCentreId(centreID);

                    return slot;
                } else {
                    throw new SQLException("Slot details not found for slotID = " + slotId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FlipFitSlots getSlotDetails(int startTime, int centreID) {
        String sql = "SELECT * FROM Slots WHERE slotTime = ? AND centreID = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, startTime);
            stmt.setInt(2, centreID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int slotid = rs.getInt("slotID");
                    int seatsAvailable = rs.getInt("seatsAvailable");

                    FlipFitSlots slot = new FlipFitSlots();
                    slot.setSlotId(slotid);
                    slot.setSlotTime(startTime);
                    slot.setSeatsAvailable(seatsAvailable);
                    slot.setCentreId(centreID);

                    return slot;
                } else {
                    throw new SQLException("Slot details not found for startTime = " + startTime + " and centreID = " + centreID);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//    public FlipFitSlots getSlotDetails(int startTime, int centreID) {
//        String sql = "SELECT * FROM Slots WHERE slotTime = ? AND centreID = ?";
//        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, startTime);
//            stmt.setInt(2, centreID);
//
//            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
//            if (affectedRows == 0) {
//                throw new SQLException("Updating slots failed, no rows affected.");
//            }
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                int slotid = rs.getInt("slotID");
////                int centreId = rs.getInt("centreID");
////                int StartTime = rs.getInt("slotTime");
//                int seatsAvailable = rs.getInt("seatsAvailable");
//                FlipFitSlots slot = new FlipFitSlots();
//                slot.setSlotId(slotid);
//                slot.setSlotTime(startTime);
//                slot.setSeatsAvailable(seatsAvailable);
//                slot.setCentreId(centreID);
//                return slot;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
//        FlipFitSlots slot = null;
//        try {
//            Connection con = GetConnection.getConnection();
//
//            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Slots WHERE slotTime = ? AND centreID = ?");
//            stmt.setLong(1, startTime);
//            stmt.setLong(2, centreID);
//
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                int slotid = rs.getInt("slotID");
//                int centreId = rs.getInt("centreID");
//                int StartTime = rs.getInt("slotTime");
//                int SeatsAvailable = rs.getInt("seatsAvailable");
//
//                slot = new FlipFitSlots();
//                slot.setSlotId(slotid);
//                slot.setSlotTime(StartTime);
//                slot.setSeatsAvailable(SeatsAvailable);
//                slot.setCentreId(centreId);
//            }
//
//            rs.close();
//            stmt.close();
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("Error retrieving slot details by ID: " + e.getMessage());
//        }
//        return slot;
//    }
//}
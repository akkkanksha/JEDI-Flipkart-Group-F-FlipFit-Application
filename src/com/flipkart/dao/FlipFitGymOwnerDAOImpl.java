package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.IFlipFitGymOwnerDAO;
import java.util.Random;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAOImpl implements IFlipFitGymOwnerDAO {
    Random rand = new Random();
    @Override
    public boolean addCentre(FlipFitGymCentre centre) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO GymCentre VALUES (?, ?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            centre.setCentreID(rand.nextInt(1000));
            stmt.setInt(1, centre.getCentreID());
            stmt.setInt(2, centre.getOwnerID());
            stmt.setInt(3, centre.getCapacity());
            stmt.setBoolean(4, centre.isApproved());
            stmt.setString(5, centre.getCity());
            stmt.setString(6, centre.getState());
            stmt.setInt(7, centre.getPincode());

            int i = stmt.executeUpdate();
            System.out.println(i + " user added");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner) {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT centreID, ownerID, capacity FROM GymCentre where ownerID=owner.userID";
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
    public void viewFlipFitCustomers() {

    }


    @Override
    public boolean editDetails() {
        return false;
    }
}

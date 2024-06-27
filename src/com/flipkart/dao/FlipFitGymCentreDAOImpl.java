package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymCentre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class FlipFitGymCentreDAOImpl {
    public void createGymCentre(FlipFitGymCentre flipFitGymCentre){
        System.out.println("Creating Gym Centre");
        try{
            Connection con = GetConnection.getConnection();
            PreparedStatement stmt=con.prepareStatement("insert into FlipFitGym values(?,?,?,?,?,?)");
            stmt.setString(1, flipFitGymCentre.getOwnerID());
            stmt.setInt(2, flipFitGymCentre.getCapacity());
            stmt.setBoolean(3, flipFitGymCentre.isApproved());
            stmt.setString(4, flipFitGymCentre.getCity());
            stmt.setString(5, flipFitGymCentre.getState());
            stmt.setString(6, flipFitGymCentre.getPincode());


            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
    public boolean updateGymCentre(FlipFitGymCentre flipFitGymCentre){

        System.out.println("Updating Gym Centre");
        try{
            Connection con = GetConnection.getConnection();
//            PreparedStatement customerStmt = con.prepareStatement("UPDATE flipfitCustomer SET customerName=?, customerPhone=?, customerAddress=? WHERE customerId=?");
//
//
//            // Execute the customer update
//            int customerUpdateCount = customerStmt.executeUpdate();
//            System.out.println(customerUpdateCount + " customer record(s) updated");

            // Close the connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
    public boolean deleteGymCentre(){
        System.out.println("Deleting Gym Centre");
        return true;

    }
    public void viewAvailableSlots(){
        System.out.println("Viewing Available Slots");
    }
}

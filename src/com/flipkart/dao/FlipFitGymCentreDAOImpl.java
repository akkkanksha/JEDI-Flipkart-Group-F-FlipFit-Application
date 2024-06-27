package com.flipkart.dao;
import java.sql.*;
import java.util.Random;
import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.constant.DBConstants;

public class FlipFitGymCentreDAOImpl {
    Random rand = new Random();
//
//    public static void main(String[] args) {
//        FlipFitGymCentre FFGC = new FlipFitGymCentre();
//
//        //test part
//        FFGC.setOwnerID(11);
//        FFGC.setApproved(true);
//        FFGC.setCapacity(45);
//        FFGC.setCity("Pune");
//        FFGC.setState("MH");
//        FFGC.setPincode(411027);
//
//        FlipFitGymCentreDAOImpl FFGCDAO = new FlipFitGymCentreDAOImpl();
//        FFGCDAO.createGymCentre(FFGC);
//        FFGCDAO.updateGymCentre(FFGC);
//        FFGCDAO.deleteGymCentre(FFGC);
//        FFGCDAO.viewAvailableSlots(FFGC);
//    }
    public void createGymCentre(FlipFitGymCentre FFGC){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO GymCentre VALUES (?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            int centreID = rand.nextInt(1000);
            stmt.setInt(1, FFGC.getCentreID());
            stmt.setInt(2, FFGC.getOwnerID());
            stmt.setInt(3,FFGC.getCapacity());
            stmt.setBoolean(4, FFGC.isApproved());
            stmt.setString(5, FFGC.getCity());
            stmt.setString(6, FFGC.getState());

            int i = stmt.executeUpdate();
            System.out.println((i+1)+"th centre added");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    };
    public void updateGymCentre(FlipFitGymCentre FFGC){
    };
    public void deleteGymCentre(FlipFitGymCentre FFGC){
    };
    public void viewAvailableSlots(FlipFitGymCentre FFGC){

    };
}

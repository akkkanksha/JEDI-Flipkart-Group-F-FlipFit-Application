package com.flipkart.dao;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.*;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class FlipFitUserDAOImpl implements IFlipFitUserDAO {
    Random rand = new Random();
//
//    public static void main(String[] args) {
//        FlipFitUser FFU = new FlipFitUser();
//
//        FFU.setUserName("PP");
//        FFU.setPassword("pp2");
//        FFU.setRoleID(1);
//        FFU.setEmailID("pp@mail");
//        FFU.setPhoneNumber("9800756987");
//
//        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();
//        FFUDAO.addUser(FFU);
//
//        FlipFitUser FFU1 = new FlipFitUser();
//
//        FFU.setUserName("GG");
//        FFU.setPassword("gg2");
//        FFU.setRoleID(0);
//        FFU.setEmailID("gg@mail");
//        FFU.setPhoneNumber("9899756987");
//
//        FFUDAO.changeUser(FFU);
//        FlipFitUser FFU2 = FFUDAO.getUser(644);
//        System.out.println(FFU2.getEmailID());
//        System.out.println(FFU2.getPhoneNumber());
//
//    }

    @Override
    public FlipFitGymCustomer login(String emailID, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * from User where email=? and password=?");
            stmt.setString(1,emailID);
            stmt.setString(2,password);
            ResultSet rsUser = stmt.executeQuery();
            if(rsUser.next()){
                stmt = con.prepareStatement("SELECT * from Customer where customerID = ?");
                stmt.setInt(1,rsUser.getInt("customerID"));
                ResultSet rsCustomer = stmt.executeQuery();
                FlipFitGymCustomer flipFitGymCustomer = new FlipFitGymCustomer();
                flipFitGymCustomer.setCity(rsCustomer.getString("city"));
                flipFitGymCustomer.setEmailID(rsUser.getString("emailID"));
                flipFitGymCustomer.setPinCode(rsCustomer.getString("pinCode"));
                flipFitGymCustomer.setPassword(rsUser.getString("password"));
                flipFitGymCustomer.setPhoneNumber(rsUser.getString("phoneNumber"));
                flipFitGymCustomer.setUserName(rsUser.getString("userName"));
                return flipFitGymCustomer;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            FFU.setUserID(rand.nextInt(1000));
            stmt.setInt(1,FFU.getUserID());
            stmt.setInt(2, FFU.getUserID());
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());


            int i = stmt.executeUpdate();
            System.out.println(i + " user added");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM User WHERE userID=(?)");

            stmt.setInt(1, FFU.getUserID());

            int i = stmt.executeUpdate();
            System.out.println(i + " user removed");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void changeUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE User SET userName = ?, roleID =? , emailId = ?, phoneNumber = ?, password = ? WHERE userID = ?"));

            stmt.setInt(1,FFU.getUserID());
            stmt.setInt(2, FFU.getUserID());
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());

            int i = stmt.executeUpdate();
            System.out.println(i + " user changed");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public FlipFitUser getUser(int userID) {
        FlipFitUser FFU = new FlipFitUser();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM User WHERE userId = ?");
            stmt.setInt(1, userID);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            FFU.setUserName(rs.getString("userName"));
            FFU.setUserID(rs.getInt("userID"));
            FFU.setPassword(rs.getString("password"));
            FFU.setPhoneNumber(rs.getString("phoneNumber"));
            FFU.setRoleID(rs.getInt("roleID"));
            FFU.setEmailID(rs.getString("emailId"));

            int i = stmt.executeUpdate();
            System.out.println(i + " user fetched");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return FFU;
    }
}

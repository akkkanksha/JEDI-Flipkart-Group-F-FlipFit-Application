package com.flipkart.dao;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.*;
import com.flipkart.bean.FlipFitUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class FlipFitUserDAOImpl implements IFlipFitUserDAO {
    Random rand = new Random();

    @Override
    public int login(String emailID, String password){
        int userID = -1;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM User WHERE emailId = ?");

            stmt.setString(1, emailID);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String pw = rs.getString("password");
                if(pw.equals(password)) userID = rs.getInt("userID");
                else System.out.println("Wrong Password, login failed");
            }
            else return -1;

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userID;
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
            stmt.setString(1, FFU.getUserName());
            stmt.setInt(2, FFU.getUserID());
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(5, FFU.getPhoneNumber());
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
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

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
    public void updateUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE User SET userName = ?, roleID =? , emailId = ?, phoneNumber = ?, password = ? WHERE userID = ?"));

            stmt.setString(1, FFU.getUserName());
            stmt.setInt(2, FFU.getRoleID());
            stmt.setString(3, FFU.getEmailID());
            stmt.setString(4, FFU.getPhoneNumber());
            stmt.setString(5, FFU.getPassword());
            stmt.setInt(6, FFU.getUserID());

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

            FFU.setUserID(rs.getInt("userID"));
            FFU.setUserName(rs.getString("userName"));
            FFU.setPassword(rs.getString("password"));
            FFU.setRoleID(rs.getInt("roleID"));
            FFU.setEmailID(rs.getString("emailId"));
            FFU.setPhoneNumber(rs.getString("phoneNumber"));

            int i = stmt.executeUpdate();
            System.out.println(i + " user fetched");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return FFU;
    }
}

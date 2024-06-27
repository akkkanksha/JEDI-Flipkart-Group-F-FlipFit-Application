package com.flipkart.dao;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.*;
import com.flipkart.bean.FlipFitUser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

public class FlipFitUserDAOImpl implements IFlipFitUserDAO {
    Random rand = new Random();

    public static void main(String[] args) {
        FlipFitUser FFU = new FlipFitUser();

        FFU.setUserName("PP");
        FFU.setPassword("pp2");
        FFU.setRoleID(1);

        FlipFitUserDAOImpl FFUDAO = new FlipFitUserDAOImpl();
        FFUDAO.addUser(FFU);
    }

    @Override
    public void addUser(FlipFitUser FFU) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            int userID = rand.nextInt(1000);
            stmt.setString(1, FFU.getUserName());
            stmt.setInt(2, userID);
            stmt.setInt(3, FFU.getRoleID());
            stmt.setString(4, FFU.getPassword());

            int i = stmt.executeUpdate();
            System.out.println((i+1)+"th user added");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(FlipFitUser FFU) {
    }

    @Override
    public void changeUser(FlipFitUser FFU) {
    }
}

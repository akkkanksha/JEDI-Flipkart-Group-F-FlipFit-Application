package com.flipkart.dao;

import com.flipkart.bean.FlipFitBooking;
import com.flipkart.bean.FlipFitPayments;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.IFlipFitPaymentsDAO;

import java.sql.ResultSet;
import java.util.Random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class FlipFitPaymentsDAOImpl implements IFlipFitPaymentsDAO {
    Random rand = new Random();

    @Override
    public List<FlipFitPayments> viewPaymentInfo(int userID){
        List<FlipFitPayments> payments = new ArrayList<>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Payments WHERE userID = ?");


            // Generate random integers in range 0 to 999
            stmt.setInt(1, userID);

            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                FlipFitPayments FFP = new FlipFitPayments();
                FFP.setUserID(userID);
                FFP.setPaymentType(rs.getInt("paymentType"));
                FFP.setPaymentInfo(rs.getString("paymentInfo"));
                payments.add(FFP);
            }
            System.out.println( "payment info viewed");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        return payments;
    };

    @Override
    public void setPaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("REPLACE INTO Payments VALUES (?, ?, ?)");


            // Generate random integers in range 0 to 999
            stmt.setInt(1, FFP.getUserID());
            stmt.setInt(2, FFP.getPaymentType());
            stmt.setString(3, FFP.getPaymentInfo());

            int i = stmt.executeUpdate();
            System.out.println( i + " payment info added");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void deletePaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM Payments WHERE userID=(?)");

            stmt.setInt(1, FFP.getUserID());

            int i = stmt.executeUpdate();
            System.out.println( i + " payment info deleted");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

}

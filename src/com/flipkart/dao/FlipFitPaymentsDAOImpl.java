package com.flipkart.dao;

import com.flipkart.bean.FlipFitPayments;
import com.flipkart.constant.DBConstants;
import com.flipkart.dao.interfaces.IFlipFitPaymentsDAO;
import java.util.Random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FlipFitPaymentsDAOImpl implements IFlipFitPaymentsDAO {
    Random rand = new Random();

    public static void main(String[] args) {
        FlipFitPayments FFP = new FlipFitPayments();
        FFP.setUserID(108);
        FFP.setPaymentType(1);
        FFP.setPaymentInfo("ppan@icici");

        FlipFitPaymentsDAOImpl FFPDAO = new FlipFitPaymentsDAOImpl();
        FFPDAO.setPaymentInfo(FFP);

        FFP.setPaymentType(2);
        FFP.setPaymentInfo("123456781298;445");
        FFPDAO.changePaymentInfo(FFP);

//        FFPDAO.deletePaymentInfo(FFP);
    }
    @Override
    public void setPaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO Payments VALUES (?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            stmt.setInt(1, FFP.getUserID());
            stmt.setInt(3, FFP.getPaymentType());
            stmt.setString(4, FFP.getPaymentInfo());

            int i = stmt.executeUpdate();
            System.out.println( i + " payment info added");

            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void changePaymentInfo(FlipFitPayments FFP) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL,DBConstants.USER,DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE Payments SET paymentType = ?, paymentInfo =? WHERE userID = ?"));


            stmt.setInt(1, FFP.getPaymentType());
            stmt.setString(2,FFP.getPaymentInfo());
            stmt.setInt(7, FFP.getUserID());

            int i = stmt.executeUpdate();
            System.out.println( i + " payment info updated");

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

package com.flipkart.dao;
import com.flipkart.constant.DBConstants;

import java.sql.*;
public class GetConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", DBConstants.PASSWORD);
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

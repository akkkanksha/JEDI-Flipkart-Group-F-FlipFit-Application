package com.flipkart.dao;
import java.sql.*;
public class GetConnection {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "Fk!@#%215019");
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

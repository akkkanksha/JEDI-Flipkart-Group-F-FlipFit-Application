package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.dao.interfaces.*;
import java.util.List;
import com.flipkart.dao.GetConnection;
import java.sql.*;
public class FlipFitAdminDAOImpl implements  IFlipFitAdminDAO {
    @Override
    public FlipFitAdmin adminLogin(String email, String password){
        try{
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt=con.prepareStatement("insert into Admin values(?,?)");
            stmt.setString(1, email);//1 specifies the first parameter in the query
            stmt.setString(2, password);

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    @Override
    public List<FlipFitGymOwner> getPendingOwnerList(int adminId){
        try{
            Connection con = GetConnection.getConnection();

            PreparedStatement stmt=con.prepareStatement("Select * from Admin where id = ?");
            stmt.setInt(1, adminId);//1 specifies the first parameter in the query


            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    @Override
    public List<FlipFitGymCustomer> getUserList() {
        return List.of();
    }

    @Override
    public boolean validateOwner(int ownerId) {
        return false;
    }

    @Override
    public boolean deleteOwner(int ownerId) {
        return false;
    }
}

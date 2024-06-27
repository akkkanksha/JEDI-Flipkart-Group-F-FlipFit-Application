package com.flipkart.dao;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.dao.interfaces.*;
import java.util.List;

public class FlipFitAdminDAOImpl implements  IFlipFitAdminDAO {
    @Override
    public boolean adminLogin(FlipFitAdmin adminUser) {
        try{
            GetConnection con= new GetConnection();

            PreparedStatement stmt=con.prepareStatement("insert into Admin values(?,?)");
            stmt.setInt(1, adminUser.getUserID());//1 specifies the first parameter in the query
            stmt.setString(2, adminUser.getPassword());

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return false;
    }

    @Override
    public List<FlipFitAdmin> getPendingOwnerList(int adminId) {
        try{
            GetConnection con= new GetConnection();

            PreparedStatement stmt=con.prepareStatement("Select * from Admin where id = ?");
            stmt.setInt(1, adminId);//1 specifies the first parameter in the query


            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}
        return null;
    }

    @Override
    public List<Object> getUserList() {
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

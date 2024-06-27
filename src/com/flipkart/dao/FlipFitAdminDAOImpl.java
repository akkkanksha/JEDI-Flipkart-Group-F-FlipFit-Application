package com.flipkart.dao;

import com.flipkart.bean.AdminUser;
import com.flipkart.dao.interfaces.IFlipFitAdminDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.List;

public class FlipFitAdminDAOImpl implements IFlipFitAdminDAO {
    @Override
    public boolean adminLogin(AdminUser adminUser) {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema","root","Karan@007");
            }catch(Exception e){
                System.out.println(e);
            }
        return false;
    }

    @Override
    public List<Object> getPendingOwnerList() {
        return List.of();
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

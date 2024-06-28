package com.flipkart.dao.interfaces;
import com.flipkart.bean.FlipFitUser;

public interface IFlipFitUserDAO {
    public int login(String emailID, String password);
    public void addUser(FlipFitUser ffu);
    public void deleteUser(FlipFitUser ffu);
    public void updateUser(FlipFitUser ffu);
    public FlipFitUser getUser(int userID);
}

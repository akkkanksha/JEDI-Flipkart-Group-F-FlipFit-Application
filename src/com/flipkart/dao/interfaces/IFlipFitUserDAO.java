package com.flipkart.dao.interfaces;
import com.flipkart.bean.FlipFitUser;

public interface IFlipFitUserDAO {
    public void addUser(FlipFitUser ffu);
    public void deleteUser(FlipFitUser ffu);
    public void changeUser(FlipFitUser ffu);
}

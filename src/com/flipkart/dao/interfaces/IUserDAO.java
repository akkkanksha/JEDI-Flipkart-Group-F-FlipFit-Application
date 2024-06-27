package com.flipkart.dao.interfaces;

public interface IUserDAO {
    public boolean addUser(int userId);
    public boolean deleteUser(int userId);
    public boolean changeUser(int userId);
}

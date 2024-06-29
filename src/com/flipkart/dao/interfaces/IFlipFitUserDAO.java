package com.flipkart.dao.interfaces;
import com.flipkart.bean.FlipFitUser;

/**
 IFlipFitUserDAO interface defines methods for managing user operations within the FlipFit Gym application.
 */
public interface IFlipFitUserDAO {

    /**
     login - It is a method which performs user login verification based on email and password.
     It takes emailID as parameter email ID of the user attempting to the login.
     And it takes password as second parameter and password associated with the user's account.
     It returns an integer representing the userID if login is successful, or a specific code indicating failure.
     */
    public int login(String emailID, String password);

    /**
     addUser - It is a methods which adds a new user to the system.
     It takes ffu as parameter and FlipFitUser object representing the user to be added.
     */
    public void addUser(FlipFitUser ffu);

    /**
     deleteUse - It is a method which deletes an existing user from the system.
     It takes ffu as parameter and FlipFitUser object to be deleted.
     */
    public void deleteUser(FlipFitUser ffu);

    /**
     changeUser - It is a method which updates the details of an existing user in the system.
     It takes ffu as parameter and FlipFitUser object containing the updated user information.
     */
    public void changeUser(FlipFitUser ffu);

    /**
     getUser - It is a method which retrieves a specific user based on the userID.
     It takes userID as parameter and ID of the user to retrieve.
     It returns an integer FlipFitUser object representing the user with the given userID.
     */
    public FlipFitUser getUser(int userID);
}

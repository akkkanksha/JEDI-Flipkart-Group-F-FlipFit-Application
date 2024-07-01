package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitAdminBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.business.interfaces.IFlipFitAdmin;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
import com.flipkart.dao.interfaces.IFlipFitAdminDAO;
import com.flipkart.exceptions.ExceptionHandler;
import com.flipkart.exceptions.InvalidChoiceException;

import java.util.*;

public class GymFlipFitApplication {
    public static void main(String[] args) throws InvalidChoiceException {
        try {
            Scanner in = new Scanner(System.in);
            int choice = 0;
            do {
                System.out.println("Welcome To FlipFit: ");
                System.out.println("Type " +
                        "\n 1-> Login, " +
                        "\n 2-> Registration of Customer " +
                        "\n 3-> Registration of Gym Owner " +
                        "\n 4-> Change Password" +
                        "\n 5-> Exit \n"
                );

                choice = in.nextInt();
                switch (choice) {
                    case 1: {
                        // Login
                        System.out.println("Login");
                        System.out.print("Enter your emailId:> ");
                        String username = in.next();
                        System.out.print("Enter your password:> ");
                        String password = in.next();
                        System.out.print("Enter your role:> Customer/Admin/GymOwner ");
                        String role = in.next();
//                        System.out.println("Login Successful");

                        switch (role) {
                            case "Customer": {
                                // customer menu
                                System.out.println("Customer Menu");
                                FlipFitGymCustomer gymCustomer = new FlipFitGymCustomer();
                                GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                                break;
                            }
                            case "Admin": {
                                // admin menu
                                FlipFitAdmin admin= new FlipFitAdmin();
                                admin.setEmailID(username);
                                admin.setPassword(password);
                                FlipFitAdminDAOImpl adminDAO = new FlipFitAdminDAOImpl();
                                IFlipFitAdmin flipFitAdmin = new FlipFitAdminBusiness(adminDAO);
                                try {
                                    boolean res=flipFitAdmin.adminLogin(admin);
                                    if(res) {
                                        System.out.println("Admin Menu");
                                        GymFlipFitAdminMenu.getAdminView();
                                    }
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                break;
                            }
                            case "GymOwner": {
                                // gym owner
                                FlipFitUser gymOwner= new FlipFitUser();
                                gymOwner.setEmailID(username);
                                gymOwner.setPassword(password);

                                FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
                                FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

                                gymOwner=GOBservice.login(gymOwner);
                                System.out.println("GymOwner Menu");
                                GymFlipFitOwnerMenu.getFlipFitOwnerView(gymOwner);
                                break;
                            }
                        }
                        break;
                    }
                    case 2: {

                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.print("Enter your password:> ");
                        String password = in.next();
                        String role = "Customer";
                        System.out.println("Registration completed");
                        System.out.println("Customer Menu");
                        FlipFitGymCustomer gymCustomer = new FlipFitGymCustomer();

                        GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                        break;
                    }
                    case 3: {
                        System.out.println("Registration of gym owner");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.print("Enter your password:> ");
                        String password = in.next();
                        String role = "GymOwner";


                        FlipFitGymOwner flipFitOwner = new FlipFitGymOwner();
                        flipFitOwner.setEmailID(emailID);
                        flipFitOwner.setPassword(password);
                        flipFitOwner.setPhoneNumber(phoneNumber);
                        flipFitOwner.setCity(city);
                        flipFitOwner.setPinCode(pinCode);

                        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
                        FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

                        GOBservice.registerOwner(flipFitOwner);

                        System.out.println("Registration completed");

                        break;
                    }
                    case 4: {
                        System.out.println("Change password");
                        break;
                    }
                    case 5: {
                        System.out.println("Exit");
                        break;
                    }
                    default: {
                        throw new InvalidChoiceException("Invalid choice entered: " + choice);
                    }
                }
            }
            while (choice != 5);
        }
        catch (InvalidChoiceException e)
        {
            ExceptionHandler.InvalidChoiceMainMenu(e);
        }
    }
}

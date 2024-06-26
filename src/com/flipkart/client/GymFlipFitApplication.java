package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitUser;
import com.flipkart.business.FlipFitAdminBusiness;
import com.flipkart.business.FlipFitGymCustomerBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.business.interfaces.IFlipFitAdmin;
import com.flipkart.dao.FlipFitAdminDAOImpl;
import com.flipkart.dao.FlipFitGymCustomerDAOImpl;
import com.flipkart.dao.FlipFitGymOwnerDAOImpl;
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
                        "\n 4-> Exit \n"
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
                                FlipFitUser gymCustomer = new FlipFitUser();
                                gymCustomer.setEmailID(username);
                                gymCustomer.setPassword(password);

                                FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
                                FlipFitGymCustomerBusiness GCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);

                                gymCustomer=GCBservice.login(gymCustomer);
                                System.out.println("Customer Menu");
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
                        System.out.println("Registration of gym customer");
                        System.out.println("Enter your email address:> ");
                        String emailID = in.next();
                        System.out.println("Enter your phone number:> ");
                        String phoneNumber = in.next();
                        System.out.println("Enter your city:> ");
                        String city = in.next();
                        System.out.println("Enter your pin code:> ");
                        String pinCode = in.next();
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();


                        FlipFitUser gymCustomer = new FlipFitUser();
                        gymCustomer.setEmailID(emailID);
                        gymCustomer.setPassword(password);
                        gymCustomer.setPhoneNumber(phoneNumber);
                        gymCustomer.setUserName(username);

                        FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
                        FlipFitGymCustomerBusiness GCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);


                        FlipFitGymCustomer flipFitGymCustomer=new FlipFitGymCustomer();
                        flipFitGymCustomer.setEmailID(emailID);
                        flipFitGymCustomer.setPassword(password);
                        flipFitGymCustomer.setPhoneNumber(phoneNumber);
                        flipFitGymCustomer.setUserName(username);
                        flipFitGymCustomer.setCity(city);
                        flipFitGymCustomer.setPinCode(pinCode);
                        flipFitGymCustomer.setRole(1);


                        flipFitGymCustomer=GCBservice.registerCustomer(flipFitGymCustomer);
                        gymCustomer.setUserID(flipFitGymCustomer.getUserId());
                        System.out.println("Registration completed");
                        System.out.println("Customer Menu");

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
                        System.out.println("Enter your password:> ");
                        String password = in.next();
                        System.out.println("Enter username: ");
                        String username = in.next();
                        System.out.println("Enter your panId: ");
                        String panId = in.next();
                        System.out.println("Enter your gstNum: ");
                        String gstNum = in.next();
                        System.out.println("Enter your aadharNumber: ");
                        String aadharNumber = in.next();



                        FlipFitGymOwner flipFitOwner = new FlipFitGymOwner();
                        flipFitOwner.setEmailID(emailID);
                        flipFitOwner.setPassword(password);
                        flipFitOwner.setPhoneNumber(phoneNumber);
                        flipFitOwner.setCity(city);
                        flipFitOwner.setPinCode(pinCode);
                        flipFitOwner.setUserName(username);
                        flipFitOwner.setRole(2);
                        flipFitOwner.setGSTIN(gstNum);
                        flipFitOwner.setAadharNumber(aadharNumber);
                        flipFitOwner.setPanId(panId);
                        flipFitOwner.setIsApproved(false);

                        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
                        FlipFitGymOwnerBusiness GOBservice = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

                        GOBservice.registerOwner(flipFitOwner);

                        System.out.println("Registration completed");

                        break;
                    }
                    case 4: {
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

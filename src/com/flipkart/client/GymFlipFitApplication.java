package com.flipkart.client;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;

import java.util.*;

public class GymFlipFitApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int choice = 0;
        do{
            System.out.println("Welcome To FlipFit: ");
            System.out.println("Type " +
                    "\n 1-> Login, " +
                    "\n 2-> Registration of Customer " +
                    "\n 3-> Registration of Gym Owner " +
                    "\n 4-> Change Password" +
                    "\n 5-> Exit \n"
            );

            choice = in.nextInt();
            switch (choice){
                case 1 : {
                    // Login
                    System.out.println("Login");
                    System.out.print("Enter your emailId:> ");
                    String username = in.next();
                    System.out.print("Enter your password:> ");
                    String password = in.next();
                    System.out.print("Enter your role:> Customer/Admin/GymOwner ");
                    String role = in.next();
                    System.out.println("Login Successful");

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
                            System.out.println("Admin Menu");
                            GymFlipFitAdminMenu.getAdminView();
                            break;
                        }
                        case "GymOwner": {
                            // gym owner
                            System.out.println("GymOwner Menu");
                            GymFlipFitOwnerMenu.getFlipFitOwnerView();
                            break;
                        }
                    }
                    break;
                }
                case 2 : {

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

                    FlipFitGymCustomer gymCustomer = new FlipFitGymCustomer();
                    // create customer
                    System.out.println("Customer Menu");
                    GymFlipFitCustomerMenu.getFlipFitCustomerMenu(gymCustomer);
                    break;
                }
                case 3 : {
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
                    String role = "Gym Owner";
                    // owner have to verify first
                    FlipFitGymOwner gymOwner = new FlipFitGymOwner();
                    // create customer
                    System.out.println("Registration completed");
                    System.out.println("GymOwner Menu");
                    GymFlipFitOwnerMenu.getFlipFitOwnerView();
                    break;
                }
                case 4 : {
                    System.out.println("Change password");
                    break;
                }
                case 5 : {
                    System.out.println("Exit");
                    break;
                }
            }

        }
        while(choice != 5);
        in.close();
    }
}
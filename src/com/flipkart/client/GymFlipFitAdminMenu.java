package com.flipkart.client;

import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitAdmin;
import com.flipkart.bean.FlipFitGymCustomer;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitAdminBusiness;
import com.flipkart.business.FlipFitGymOwnerBusiness;
import com.flipkart.business.interfaces.IFlipFitAdmin;

import java.util.List;
import java.util.Scanner;

public class GymFlipFitAdminMenu {
    public static void getAdminView() {
        Scanner sc=new Scanner(System.in);
        FlipFitAdmin adminUser = new FlipFitAdmin();
        FlipFitAdminBusiness adminService = new FlipFitAdminBusiness(adminUser);
        FlipFitGymOwnerBusiness ownerService = new FlipFitGymOwnerBusiness();
        System.out.println("1. View Pending Requests");
        System.out.println("2. View Approved Owners");
        System.out.println("3. View all FlipFit Customers");
        System.out.println("4. View all Centres Using OwnerId");
        int choice=sc.nextInt();

        switch (choice){
            case 1:{
                String adminId = "101";
                List<FlipFitGymOwner> flipFitGymOwnerList=  adminService.getPendingOwnerList();
                for(FlipFitGymOwner flipFitGymOwner: flipFitGymOwnerList){
                    System.out.println("Owner name :" + flipFitGymOwner.getUserName() + " City :" + flipFitGymOwner.getCity());
                }
                System.out.println("Type the ownerId of owner you wish to approve");
                String ownerId = sc.next();
                // Approve owner



            }
            case 2:{
                System.out.println("Printing list of Approved Owners");
                List<FlipFitGymOwner> flipFitGymOwnerList=  adminService.getPendingOwnerList();
                for(FlipFitGymOwner flipFitGymOwner: flipFitGymOwnerList){
                    if(flipFitGymOwner.isApproved() == true) {
                        System.out.println("Owner name :" + flipFitGymOwner.getUserName() + " City :" + flipFitGymOwner.getCity());
                    }
                }
                break;
            }
            case 3:{
                List<FlipFitGymCustomer> customersList = adminService.getUserList();
                for(FlipFitGymCustomer customers: customersList){
                    System.out.println("Customer name: " + customers.getUserName() + " City :" + customers.getCity());
                }

                break;
            }
            case 4:{
                System.out.println("Printing All Centres of Owner");
                System.out.println("Type the ownerId of owner for which you wish to view Centres");
                Scanner in = new Scanner(System.in);
                int ownerId = in.nextInt();


                break;
            }
        }
    }
}

package com.flipkart.client;

import com.flipkart.bean.AdminUser;
import com.flipkart.business.AdminUserBusiness;
import com.flipkart.business.interfaces.IAdminUser;

import java.util.Scanner;

public class GymFlipFitAdminMenu {
    public static void getAdminMenu() {
        Scanner sc=new Scanner(System.in);
        AdminUser adminUser = new AdminUser();
        IAdminUser adminService = new AdminUserBusiness(adminUser);
        System.out.println("1. View Pending Requests");
        System.out.println("2. View Approved Owners");
        System.out.println("3. View all  FlipFit Customers");
        System.out.println("4. View all Centre Using OwnerId");
        int choice=sc.nextInt();

        switch (choice){
            case 1:{
                adminService.getPendingOwnerList();
                break;
            }
            case 2:{
                System.out.println("Printing list of Approved Owners");
                break;
            }
            case 3:{
                adminService.getUserList();
                break;
            }
            case 4:{
                System.out.println("Printing All Centres of Owner");
                break;
            }
        }
    }
}

package com.flipkart.client;

import com.flipkart.bean.AdminUser;
import com.flipkart.business.AdminUserBusiness;
import com.flipkart.business.interfaces.IAdminUser;

public class GymFlipFitAdminMenu {
    public static void getAdminMenu() {
        AdminUser adminUser = new AdminUser();
        IAdminUser adminService = new AdminUserBusiness(adminUser);
        int ownerId=101;
        adminService.adminLogin(adminUser);
        adminService.getPendingOwnerList();
        adminService.getUserList();
//        adminService.validateOwner(ownerId);
//        adminService.deleteOwner(ownerId);
    }
}

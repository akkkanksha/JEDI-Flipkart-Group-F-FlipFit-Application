package com.flipkart.client;
import com.flipkart.business.FlipFitCustomerBusiness;

public class FlipFitCustomerClientApp {
	public static void main() {
		FlipFitCustomerBusiness service = new FlipFitCustomerBusiness();
		int userId=101;
		int startTime=7;
		service.viewBookedSlots(userId);
		service.checkBookingConflicts(userId,startTime);
		service.viewCentres(userId);
		service.makePayment(userId);
		service.editDetails(userId);
	}
	
}

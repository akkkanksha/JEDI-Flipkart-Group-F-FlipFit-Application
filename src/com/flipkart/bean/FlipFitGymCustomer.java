/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class FlipFitGymCustomer extends AbstractUser {
	public int paymentType;
    public String paymentInfo;
    
	public int getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentInfo() {
		return paymentInfo;
	}
	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}
}

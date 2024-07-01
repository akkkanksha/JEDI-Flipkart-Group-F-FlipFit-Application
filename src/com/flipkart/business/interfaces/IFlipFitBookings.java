package com.flipkart.business.interfaces;

import com.flipkart.bean.FlipFitBooking;

public interface IFlipFitBookings{
    public FlipFitBooking makeBooking(int userID, int centreID, int startTime);
    public boolean deleteBooking(int bookingId);
}
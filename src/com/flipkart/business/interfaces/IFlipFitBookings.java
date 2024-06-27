package com.flipkart.business.interfaces;

import com.flipkart.bean.FlipFitBooking;

public interface IFlipFitBookings{
    public void makeBooking(FlipFitBooking flipFitBooking);
    public boolean deleteBooking(int bookingId);
}
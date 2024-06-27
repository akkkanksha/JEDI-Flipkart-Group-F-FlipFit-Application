package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitBooking;

import java.util.List;

public interface IFlipFitBookingDAO {
    public void makeBooking(FlipFitBooking booking);
    boolean deleteBooking(int booking);
    public List<FlipFitBooking> getAllBookings(int userId);
}

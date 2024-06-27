package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitBooking;

public interface IFlipFitBookingDAO {
    public void makeBooking(FlipFitBooking booking);
    boolean deleteBooking(int booking);

}

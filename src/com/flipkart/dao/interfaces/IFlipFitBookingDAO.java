package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitBooking;

public interface IFlipFitBookingDAO {
    public FlipFitBooking makeBooking(int userId, int slotId, boolean isdeleted);
    public boolean deleteBooking(int bookingId);
}

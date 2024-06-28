package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitBooking;

import java.util.ArrayList;
import java.util.List;

public interface IFlipFitBookingDAO {

    // makeBooking - It is a method to make a new booking.
    // It takes FlipFitBooking object as a parameter and adds it to the booking.
    // Since, it is a void type, this method does not return any value.
    public void makeBooking(FlipFitBooking booking);

    // deleteBooking - It is a method to delete an already existing booking.
    // It takes an integer bookingId as a parameter to identify which booking to delete.
    // It returns a boolean as true or false which indicates if the deletion was successful or not.
    // if successful - true, if not successful - false
    boolean deleteBooking(int bookingId);

    // FlipFitBooking - It is a method to retrieve/get all the bookings for a specific user.
    // It takes an integer userId as a parameter to identify which user's bookings to retrieve/get.
    public List<FlipFitBooking> getAllBookings(int userId);

    // getBookingDetails - It is a method to get detailed information about a specific booking.
    // It takes an integer bookingId as a parameter to identify which booking's details to retrieve.
    // It returns a list of FlipFitBooking objects, with one element representing the booking details.
    // It returns multiple elements if there are multiple records or details associated with the booking.
    public List<FlipFitBooking> getBookingDetails(int bookingId);

}

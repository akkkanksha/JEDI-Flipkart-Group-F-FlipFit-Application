package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;

import java.util.List;

public interface IFlipFitGymCentreDAO {

        public FlipFitGymCentre createGymCentre(String ownerID, int capacity, boolean approved, String city, String state, String pincode);
        public boolean updateGymCentre();
        public boolean deleteGymCentre();
        public List<FlipFitSlots> viewAvailableSlots(String centreId);
}

package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;
import java.util.List;

public interface IFlipFitGymCentreDAO {
        public void createGymCentre(FlipFitGymCentre FFGC);
        public void updateGymCentre(FlipFitGymCentre FFGC);
        public void deleteGymCentre(FlipFitGymCentre FFGC);
        public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner owner);
        public List<FlipFitGymCentre> viewAllCentres();
        public FlipFitGymCentre getGymCentreDetailsByID(int gymCentreID);
//        public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC);
        public ArrayList<FlipFitGymCentre> viewCentresOfCity(String city);
}

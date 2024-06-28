package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;

public interface IFlipFitGymCentreDAO {
        public void createGymCentre(FlipFitGymCentre FFGC);
        public void updateGymCentre(FlipFitGymCentre FFGC);
        public void deleteGymCentre(int centreID);
        public ArrayList<FlipFitSlots> viewAvailableSlots(int centreID);
        public ArrayList<FlipFitGymCentre> viewCentresByCity(String city);
}

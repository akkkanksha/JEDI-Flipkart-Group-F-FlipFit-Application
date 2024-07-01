package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;

public interface IFlipFitGymCentreDAO {
        public FlipFitGymCentre createGymCentre(FlipFitGymCentre FFGC);
        public FlipFitGymCentre updateGymCentre(FlipFitGymCentre FFGC);
        public void deleteGymCentre(FlipFitGymCentre FFGC);
        public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC);
        public ArrayList<FlipFitGymCentre> viewCentres(String city);
}

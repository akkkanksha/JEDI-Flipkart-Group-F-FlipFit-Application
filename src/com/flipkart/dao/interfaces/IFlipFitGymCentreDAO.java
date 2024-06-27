package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;

public interface IFlipFitGymCentreDAO {
        public void createGymCentre(FlipFitGymCentre FFGC);
        public void updateGymCentre(FlipFitGymCentre FFGC);
        public void deleteGymCentre(FlipFitGymCentre FFGC);
        public void viewAvailableSlots(FlipFitGymCentre FFGC);
}

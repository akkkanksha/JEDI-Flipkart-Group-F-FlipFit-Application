package com.flipkart.dao.interfaces;

import com.flipkart.bean.FlipFitGymCentre;
import com.flipkart.bean.FlipFitSlots;

import java.util.ArrayList;


/**
 IFlipFitGymCentreDAO interface defines methods for managing gym centres within the FlipFit Gym application.
 It includes operations for creating, updating, deleting gym centres, and viewing available slots and centres.
 */
public interface IFlipFitGymCentreDAO {

        /**
         createGymCentre - It is a method which Creates a new gym centre.
         It takes FFGC as a parameter and A FlipFitGymCentre object representing the gym centre to be created.
         */
        public void createGymCentre(FlipFitGymCentre FFGC);

        /**
         updateGymCentre - It is a method which Updates the details of an existing gym centre.
         It takes FFGC as a parameter and A FlipFitGymCentre object containing the updated details of the gym centre.
         */
        public void updateGymCentre(FlipFitGymCentre FFGC);

        /**
         Deletes an existing gym centre.
         It takes FFGC as a parameter and A FlipFitGymCentre object representing the gym centre to be deleted.
         */
        public void deleteGymCentre(FlipFitGymCentre FFGC);

        /**
         viewAvailableSlots - It is a method which Retrieves a list of available slots for a specific gym centre.
         It takes FFGC as a parameter and A FlipFitGymCentre object representing the gym centre for which to view available slots.
         It returns an ArrayList of FlipFitSlots objects representing the available slots in the specified gym centre.
         */
        public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC);

        /**
         Retrieves a list of gym centres in a specific city.
         It takes city as parameter and the name of the city for which to view gym centres.
         It returns an ArrayList of FlipFitGymCentre objects representing the gym centres in the specified city.
         */
        public ArrayList<FlipFitGymCentre> viewCentres(String city);
}

package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActiveBusinessesEnum {

    /**
     * Given a list of user interaction events on Yelp, return a list of active business ids.
     * A business is considered active if in at least two event types it has greater than or equal to number of events
     * than the average for that event type across all businesses.
     */

    enum EventTypes {
        ADS,
        PAGE_VIEWS,
        PHOTO_VIEWS,
        REVIEWS
    }

    static class Businesses {
        EventTypes eventTypes;
        int occurence;
        int businessId;

        Businesses(EventTypes eventType, int occurence, int businessId) {
            this.eventTypes = eventType;
            this.occurence = occurence;
            this.businessId = businessId;
        }
    }



    public static List<Integer> findActiveBusinesses(List<Businesses> list) {

        //Step 1: create a map of event types to int array for parameters to calculate average

        //Step 2: run through each entry in the map, and calculate average

        //Step 3:


        return new ArrayList<>();

    }


    public static void main(String[] args) {
        List<Businesses> list = Arrays.asList(
                new Businesses(EventTypes.ADS, 7, 3),
                new Businesses(EventTypes.ADS, 8, 2),
                new Businesses(EventTypes.ADS, 5, 1),
                new Businesses(EventTypes.PAGE_VIEWS, 11, 2),
                new Businesses(EventTypes.PAGE_VIEWS, 12, 3),
                new Businesses(EventTypes.PHOTO_VIEWS, 10, 3),
                new Businesses(EventTypes.REVIEWS, 7, 2)
        );

        System.out.println(findActiveBusinesses(list));
    }
}

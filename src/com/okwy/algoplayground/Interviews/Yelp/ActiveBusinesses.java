package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class ActiveBusinesses {

    /**
     * Given a list of user interaction events on Yelp, return a list of active business ids.
     * A business is considered active if in at least two event types it has greater than or equal to number of events
     * than the average for that event type across all businesses.
     */


    static class Event {

        String eventType;
        int occurence;
        int biz_id;

        Event(String eventType, int occurence, int biz_id) {
            this.eventType = eventType;
            this.occurence = occurence;
            this.biz_id = biz_id;

        }

    }


    private static List<Integer> getActiveBusinesses(List<Event> list) {
        List<Integer> result = new ArrayList<>();

        //first create a map for holding event type and array to hold average calculation variables
        Map<String, int[]> eventMap = new HashMap<>();


        //this will hold the highest value an event business id will be
        int maxId = 0;

        //Run through the list of events once
        for (Event e : list) {
            //set max biz_id
            maxId = Math.max(maxId, e.biz_id);
            System.out.println("-------------------------------------------------");
            System.out.println(">>>>>>Event e is >> | " + e.eventType + " | " + e.occurence + " | " + e.biz_id + " | ");

            //Check if the event type exist in the map, if not simply put with empty array of length 3
            if (!eventMap.containsKey(e.eventType)) {
                eventMap.put(e.eventType, new int[3]);
            }

            //after insertion, time to get our av setup array
            int[] averageSetup = eventMap.get(e.eventType);
            System.out.println(">>>>>>average setup>>" + Arrays.toString(averageSetup));
            System.out.println(">>>>>>max>" + maxId);
            if (e.occurence > 0) {
                averageSetup[0] += e.occurence; //sum the total occurences
                System.out.println(">>>>>>averageSetup[0]>" + averageSetup[0]);
                averageSetup[1] += 1; //sum the total number event type occurs
                System.out.println(">>>>>>averageSetup[1]>" + averageSetup[1]);
                averageSetup[2] = averageSetup[0] / averageSetup[1]; //find average
                System.out.println(">>>>>>averageSetup[2]>" + averageSetup[2]);
            }
        }


        int[] businessIds = new int[maxId + 1];

        System.out.println();
        System.out.println("-################################################");
        System.out.println("-################################################");
        System.out.println();

        for (Event e : list) {

            System.out.println("-------------------------------------------------");
            System.out.println(">>>>>>businessIds> " + Arrays.toString(businessIds));
            System.out.println(">>>>>>e.occurence> " + e.occurence);
            System.out.println(">>>>average = eventMap.get(e.eventType)[2]>>>" + eventMap.get(e.eventType)[2]);
            System.out.println(">>>>>>businessIds[e.biz_id]>" +businessIds[e.biz_id]);

            if (e.occurence >= eventMap.get(e.eventType)[2]) {
                businessIds[e.biz_id]++;
            }
            System.out.println(">>>>>>businessIds[e.biz_id]++;>" + businessIds[e.biz_id]);

        }

        System.out.println();
        System.out.println();


        for (int i = 0; i < businessIds.length; i++) {
            if (businessIds[i] >= 2) {
                System.out.println(">>>>>>res>" + result);
                result.add(i);
            }
        }

        return result;

    }


    public static void main(String[] args) {
        List<Event> test = new ArrayList<>();

        test.add(new Event("ads", 7, 3));
        test.add(new Event("ads", 8, 2));
        test.add(new Event("ads", 5, 1));
        test.add(new Event("page_views", 11, 2));
        test.add(new Event("page_views", 12, 3));
        test.add(new Event("photo_views", 10, 3));
        test.add(new Event("reviews", 7, 2));

        System.out.println(">>>>>>>>" + getActiveBusinesses(test));

    }
}

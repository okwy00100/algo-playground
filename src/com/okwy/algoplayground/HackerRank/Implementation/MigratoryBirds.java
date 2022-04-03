package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.*;

public class MigratoryBirds {


    /**
     *
     * Given an array of bird sightings where every element represents a bird type id,
     * determine the id of the most frequently sighted type. If more than 1 type has been spotted that maximum amount,
     * return the smallest of their ids.
     *
     * */

    private static int migratoryBirds(List<Integer> arr) {
        // Write your code here

        Map<Integer, Integer> count = new HashMap<>();
        for(Integer i : arr){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();


    }

    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1, 4, 4, 4, 5, 3);

        System.out.println(">>>>>>>>" + migratoryBirds(input));
    }
}

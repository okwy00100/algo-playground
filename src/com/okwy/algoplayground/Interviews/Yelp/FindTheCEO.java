package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class FindTheCEO {

    /**
     *
     * Given a new class Pair<Manager, Reportee>, the manager can manage the reportee. Now we have a lot of pairs
     * and we can draw a tree to represent the relationship among all the workers. Now we need to find the root,
     * the CEO of this tree.
     *
     * */


    private static String getTheBoss(List<List<String>> employeePairs){

        //Lets's have a set capturing the all regular employees
        Set<String> regulars = new HashSet<>();

        for(List<String> employeePair : employeePairs){
            regulars.add(employeePair.get(1));
        }

        for(List<String> employeePair : employeePairs){
            if(!regulars.contains(employeePair.get(0))) return employeePair.get(0);
        }

        return "";
    }


    public static void main(String[] args) {

        List<List<String>> staff = new ArrayList<>();
        List<String> first = Arrays.asList("Bill Gates","Salman Kahn");
        List<String> second = Arrays.asList("Salman Kahn", "John Doe");
        List<String> third = Arrays.asList("Salman Kahn", "Steve Travor");
        List<String> fourth = Arrays.asList("John Doe", "Dante Bridges");
        List<String> fifth = Arrays.asList("Steve Travor","America Chavez");
        List<String> sixth = Arrays.asList("Steve Travor","Norton Till");
        List<String> last = Arrays.asList("Norton Till", "Vergil Dust");

        staff.add(first);
        staff.add(second);
        staff.add(third);
        staff.add(fourth);
        staff.add(fifth);
        staff.add(sixth);
        staff.add(last);

        System.out.println(">>>>>>>>>>>>" + getTheBoss(staff));

    }
}

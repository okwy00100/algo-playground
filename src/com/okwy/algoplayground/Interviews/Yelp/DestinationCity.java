package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class DestinationCity {


    /**
     *
     * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from
     * cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
     *
     * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one
     * destination city.
     *
     *
     *
     * Example 1:
     * Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * Output: "Sao Paulo"
     * Explanation: Starting at "London" city you will reach "Sao Paulo" city which is the destination city.
     * Your trip consist of: "London" -> "New York" -> "Lima" -> "Sao Paulo".
     *
     * Example 2:
     * Input: paths = [["B","C"],["D","B"],["C","A"]]
     * Output: "A"
     * Explanation: All possible trips are:
     * "D" -> "B" -> "C" -> "A".
     * "B" -> "C" -> "A".
     * "C" -> "A".
     * "A".
     * Clearly the destination city is "A".
     *
     * */


    private static String destCity(List<List<String>> paths) {

        Set<String> source = new HashSet<>();
        for(List<String> path : paths){
            source.add(path.get(0));
        }

        for(List<String> path : paths){
            if(!source.contains(path.get(1))) return path.get(1);
        }

        return "";
    }

    public static void main(String[] args) {

        List<List<String>> routes = new ArrayList<>();
        //paths -> [["B","C"],["D","B"],["C","A"]]
        List<String> first = Arrays.asList("B","C");
        List<String> second = Arrays.asList("D","B");
        List<String> third = Arrays.asList("C","A");

        routes.add(first);
        routes.add(second);
        routes.add(third);

        System.out.println(">>>>>>>>>>>>" + destCity(routes));

    }
}

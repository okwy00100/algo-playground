package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;
import java.util.stream.Collectors;

public class DetectOrderBusiness {
    /**
     * Apparently Yelp has a thing for modelling their questions based on Businesses.
     * <p>
     * This problem deals with Chain Businesses i.e businesses that operate in multiple locations.
     * <p>
     * The problem was given a list of Buisnesses which are at a target location, return a sorted
     * (ascending) list of Chains. The chains are ordered based on the frequency of occurence. The list
     * can contain duplicate business chains i.e same business name, id and location appearing more than once.
     * We break frequency ties by ordering the chain names alphabetically.
     * <p>
     * The approach taken is as follows
     * - First, to use a Set to keep track of chains I had seen before
     * - Next, to use a Map to hold the business name to Chain/Frequency relationship
     * - Then finally, a Priority Queue to help with the ordering.
     */


    static class Business {
        String name;
        String location;
        String id;

        Business(String name, String location, String id) {
            this.name = name;
            this.location = location;
            this.id = id;
        }

        @Override
        public String toString() {
            return "Business{" +
                    "name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", id='" + id + '\'' +
                    '}';
        }
    }

    static class Chain {
        String name;
        Integer frequency;

        Chain(String name, Integer frequency) {
            this.name = name;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Chain{" +
                    "name='" + name + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }

    private static List<Chain> detectAndOrderChainBusiness(List<Business> businesses, String location) {

        List<Chain> result = new ArrayList<>();

        //First let's declare set to keep track of the unique businesses
        Set<String> seenBusiness = new HashSet<>();
        //Next we declare a map for business to chain relationship
        Map<String, Chain> chainMap = new HashMap<>();

        //Next we run through all businesses in location passed
        for (Business b : businesses) {
            //check if it exists in the set, else add
            if (b.location.equals(location) && !seenBusiness.contains(b.name + b.id)) {//for uniqueness
                seenBusiness.add(b.name + b.id);
                //after adding in set, check if it exists in map
                if (chainMap.containsKey(b.name)) {
                    chainMap.get(b.name).frequency++;
                } else {
                    chainMap.put(b.name, new Chain(b.name, 1));
                }
            }
        }

        //Initialize the priority queue for ordering the chain of businesses
        PriorityQueue<Chain> chainQueue = new PriorityQueue<>((a,b) -> a.frequency.compareTo(b.frequency) == 0 ?  a.name.compareTo(b.name) : Integer.compare(b.frequency, a.frequency));


//        for (Map.Entry<String, Chain> entry : chainMap.entrySet()) {
//            chainQueue.add(entry.getValue());
//        }

        for (String entry : chainMap.keySet()) {
            chainQueue.add(chainMap.get(entry));
        }

        System.out.println(">>>>>>>>>>>>>>>Between add entry and poll");

        while (!chainQueue.isEmpty()) {
            result.add(chainQueue.poll());
        }

        return result;

    }


    private static List<Chain> detectAndOrderChainBusinessTwo(List<Business> businesses, String location) {
        List<Chain> chainBusinessess = new ArrayList<>();
        // id
        Set<String> uniqueBussiness = new HashSet<>();
        //name , count
        Map<String, Integer> countMap = new HashMap<>();

        Comparator<Chain> customComparator = new Comparator<Chain>() {
            @Override
            public int compare(Chain o1, Chain o2) {
                if (o1.frequency.compareTo(o2.frequency) == 0) {
                    return o1.name.compareTo(o2.name);
                }
                return o2.frequency.compareTo(o1.frequency);
            }
        };
        businesses.stream()
                .filter(business -> business.location.equalsIgnoreCase(location))
                .forEach(
                        business -> {
                            if (!uniqueBussiness.contains(business.id)) {
                                uniqueBussiness.add(business.id);
                                countMap.put(business.name, countMap.getOrDefault(business.name, 0) + 1);
                            }
                        }
                );
        ;
        countMap.forEach(
                (name, count) -> {
                    chainBusinessess.add(new Chain(name, count));
                }
        );

        return chainBusinessess.stream().sorted(customComparator).collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<Business> businesses = new ArrayList<>();
        businesses.add(new Business("Dangote", "Lagos", "1"));
        businesses.add(new Business("Dangote", "Lagos", "2"));
        businesses.add(new Business("Xbox", "Lagos", "3"));
        businesses.add(new Business("Microsoft", "Lagos", "4"));
        businesses.add(new Business("GT Bank", "Lagos", "5"));
        businesses.add(new Business("Dangote", "Abuja", "1"));
        businesses.add(new Business("Dangote", "Abuja", "2"));
        businesses.add(new Business("Xbox", "Abuja", "3"));


        System.out.println(detectAndOrderChainBusiness(businesses, "Lagos"));
        System.out.println(detectAndOrderChainBusinessTwo(businesses, "Lagos"));

    }
}

package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsUsingPrefix {
    /**
     *
     * You are given an array of strings products and a string searchWord.
     *
     * Design a system that suggests at most three product names from products after each character of searchWord is typed.
     * Suggested products should have common prefix with searchWord. If there are more than three products with a common
     * prefix return the three lexicographically minimums products.
     *
     * Return a list of lists of the suggested products after each character of searchWord is typed.
     *
     * This solution is is implemented by Sorting list of words and using binary search to find the position of each
     * prefix in the search word
     * */


    private static List<List<String>> suggestedProducts(String[] products, String searchWord) {

        /**
         * Intuition
         * ---------
         * In a sorted list of words,
         * for any word A[i],
         * all its suggested words must follow this word in the list.
         *
         * For example, if A[i] is a prefix of A[j],
         * A[i] must be the prefix of A[i + 1], A[i + 2], ..., A[j]
         *
         * Explanation
         * -----------
         * With this observation,
         * we can binary search the position of each prefix of each search word,
         * and check if the next 3 words is a valid suggestion.
         */

        List<List<String>> result = new ArrayList<>();

        TreeMap<String, Integer> map = new TreeMap<>();

        Arrays.sort(products);  //sort string list

        List<String> productList = Arrays.asList(products);

        for(int i = 0; i < products.length; i++){
            map.put(products[i], i);        //insert all strings into the treemap
        }

        String key = "";

        for(char c : searchWord.toCharArray()){
            System.out.println("\n-------------------------------");
            System.out.println(">>>>>>For word >>" + searchWord + " we are on letter >>" + c);
            System.out.println("-------------------------------");
            System.out.println(">>key before increment>>>" + key);
            key += c;
            System.out.println(">>key after increment>>>" + key);
            String ceiling = map.ceilingKey(key);
            System.out.println(">>>>Ceiling>>>>>> " + ceiling);
            String floor = map.floorKey(key + "~");
            System.out.println(">>>>Floor>>>>>> " + floor);

            if(ceiling == null || floor == null) break;

            System.out.println("--------------------------------------------------------");
            System.out.println(">>>>>>>>>>>>Sublist>>>" + productList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
            System.out.println("--------------------------------------------------------");


            result.add(productList.subList(map.get(ceiling), Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }



        while(result.size() < searchWord.length())
            result.add(new ArrayList<>());

        return result;
    }


    public static void main(String[] args) {

        String search = "mouse";
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};

        System.out.println(">>>>>" + suggestedProducts(products, search));

    }
}

package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrefixSearchBruteForce {

    /**
     * Given a list of business_names (strings) and a searchTerm (string).
     * Return a list of business_names that contains searchTerm as prefix in the business_names.
     ***********************************************
     * E.g.
     * Example 1.
     * Input:
     * business_names[] = { "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"}
     * searchTerm = "bur"
     *
     * Output:
     * ["burger king", "super duper burger's"]
     **********************************************
     * Example 2
     * Input:
     * business_names[] = { "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"}
     * searchTerm = "duper bur"
     *
     * Output:
     * ["super duper burger's"]
     *
     * */

    private static List<String> getRelatedString(List<String> businessNames, String searchTerm){

        return businessNames.stream()
                .filter(names -> names.contains(searchTerm))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {

        List<String> test = Arrays.asList( "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut");

        String searchTerm = "bur";


        System.out.println(getRelatedString(test, searchTerm));

    }
}

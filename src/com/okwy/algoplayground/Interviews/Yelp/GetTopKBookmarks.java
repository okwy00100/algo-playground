package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetTopKBookmarks {




    private static List<String> getTopKBookmarks(List<String> businesses, String searchTerm, int k){

        List<String> result = new ArrayList<>();

        for(String biz : businesses){
            for(String b : biz.split(" ")){
                if(b.startsWith(searchTerm)){
                    result.add(biz);
                    break;
                }
            }

        }


        return result.size() >= k ? result.subList(0, k) : result;

    }


    public static void main(String[] args) {
        List<String> input = Arrays.asList("burger king", "burger burger", "McDonald's", "super duper burger's", "subway", "pizza hut");

        String searchword = "burger";

        int limit = 2;

        System.out.println(">>>>>" + getTopKBookmarks(input, searchword, limit));
    }
}

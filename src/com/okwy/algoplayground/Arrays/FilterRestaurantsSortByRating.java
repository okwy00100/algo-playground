package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.List;


public class FilterRestaurantsSortByRating {


    /**
     * Given the array restaurants where  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei].
     * You have to filter the restaurants using three filters.
     * The veganFriendly filter will be either true (meaning you should only include restaurants with veganFriendlyi set to true) or
     * false (meaning you can include any restaurant). In addition, you have the filters maxPrice and maxDistance which are the maximum
     * value for price and distance of restaurants you should consider respectively.
     * Return the array of restaurant IDs after filtering, ordered by rating from highest to lowest.
     *
     * For restaurants with the same rating, order them by id from highest to lowest.
     * For simplicity veganFriendlyi and veganFriendly take value 1 when it is true, and 0 when it is false.

     */

    static class Restaurant{
        int id;
        int rating;

        Restaurant(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }

    private static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<Integer> result = new ArrayList<>();

        List<Restaurant> restaurantList = new ArrayList<>();

        for(int[] r : restaurants){
            int id = r[0];
            int rating = r[1];
            int vegan = r[2];
            int price = r[3];
            int distance = r[4];

            if(veganFriendly == 1){
                if(vegan == 1 && price <= maxPrice && distance <= maxDistance){
                    restaurantList.add(new Restaurant(id, rating));
                }

            }else{
                if(price <= maxPrice && distance <= maxDistance){
                    restaurantList.add(new Restaurant(id, rating));
                }
            }

        }


        restaurantList.sort((a, b) -> a.rating == b.rating ? b.id - a.id : b.rating - a.rating);

        for(Restaurant r : restaurantList){
            result.add(r.id);
        }



        return result;

        /////////////////////////////////////////////////////////////////////////////////
        //Time complexity -> O(n+m)
        //Space complexity -> O(n)
        ///////////////////////////////////////////////////////////////////////////////
    }



    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(2);
        test.add(3);

        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        int veganFriendly = 1,  maxPrice = 50,  maxDistance = 10;



        System.out.println(test);

        System.out.println(">>>>>>>>>>" + filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));

    }
}

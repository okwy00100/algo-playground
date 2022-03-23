package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterRestaurants {

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

        public Restaurant(int id, int rating) {
            this.id = id;
            this.rating = rating;
        }
    }

    private static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> result = new ArrayList<>();

        List<Restaurant> filteredRestaurants = new ArrayList<>();

        for(int[] restaurant : restaurants){
            int id = restaurant[0];
            int rate = restaurant[1];
            int vegan = restaurant[2];
            int price = restaurant[3];
            int distance = restaurant[4];

            if(veganFriendly == 1){
                if(vegan == 1 && price <= maxPrice && distance <= maxDistance){
                    filteredRestaurants.add(new Restaurant(id, rate));
                }
            }else{
                if(price <= maxPrice && distance <= maxDistance){
                    filteredRestaurants.add(new Restaurant(id, rate));
                }
            }

        }

        Collections.sort(filteredRestaurants, (a,b) -> a.rating == b.rating ? b.id - a.id : b.rating - a.rating);

        for(Restaurant r : filteredRestaurants){
            result.add(r.id);
        }

        return result;
    }


    public static void main(String[] args) {

        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}, {6,1,1,15,1}};
        int veganFriendly = 1, maxPrice = 50, maxDistance = 10;

        System.out.println(">>>>>>>>>>>>" + filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance));
    }
}

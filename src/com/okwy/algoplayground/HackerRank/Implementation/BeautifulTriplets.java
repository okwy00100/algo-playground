package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.List;

public class BeautifulTriplets {



    public static int beautifulTriplets(int d, List<Integer> arr) {
        // Write your code here
        int count = 0;

        for(Integer i : arr){
            if(arr.contains(i + d) && arr.contains(i + 2*d)){
                count++;
            }
        }

        return count;
    }



    public static void main(String[] args) {

    }
}

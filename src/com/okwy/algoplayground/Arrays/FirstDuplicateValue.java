package com.okwy.algoplayground.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {


    //My brute-force first attempt 😁
    public static int firstDuplicateValue(int[] array) {
        // Time: O(n), Space: O(n).
        Set<Integer> packs = new HashSet<>();

        for (int i = 0; i < array.length; i++){
            if(packs.contains(array[i])){
                return array[i];
            }
            packs.add(array[i]);
        }

        return -1;
    }


    public static void main(String[] args) {

        int[] inputArray = {7, 2, 3, 5, 1, 9, 2, 8};
        System.out.println(">> Input Array >>" + Arrays.toString(inputArray));
        System.out.println(">> Output Array (1) >> " + firstDuplicateValue(inputArray));

    }
}

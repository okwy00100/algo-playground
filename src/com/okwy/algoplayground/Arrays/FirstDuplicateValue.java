package com.okwy.algoplayground.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstDuplicateValue {


    //My brute-force first attempt 😁
    private static int firstDuplicateValueOne(int[] array) {
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

    private static int firstDuplicateValueTwo(int[] array){
        //Time: O(n), Space: O(1).
        //Considering the array consists of integers between 1 and n, where n = array.length
        //Assuming any one of the integers mentioned above occurs more than once

        for(int i=0; i < array.length; i++){
            int absIndex = Math.abs(array[i]);
            if(array[absIndex - 1] < 0){
                return absIndex;
            }
            array[absIndex - 1] *= -1;
        }


        return -1;
    }


    public static void main(String[] args) {

        int[] inputArray = {7, 2, 3, 5, 1, 4, 2, 8};
        System.out.println(">> Input Array >>" + Arrays.toString(inputArray));
        System.out.println(">> Output (1) >> " + firstDuplicateValueOne(inputArray));
        System.out.println(">> Output (2) >> " + firstDuplicateValueTwo(inputArray));

        System.out.println(args.length);

        for(String a : args){
            System.out.println(a);
        }

    }
}

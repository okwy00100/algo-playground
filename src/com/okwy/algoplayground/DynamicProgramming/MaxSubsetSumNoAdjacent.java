package com.okwy.algoplayground.DynamicProgramming;

import java.util.Arrays;

public class MaxSubsetSumNoAdjacent {

    private static int maxSubsetSumNoAdjacentOne(int[] array) {
        //Time:O(n), Space:O(n)
        //Base case
        if(array.length == 0){
            return 0;
        }else if(array.length == 1){
            return array[0];
        }

        int[] maxSums = new int[array.length];

        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);

        for(int i = 2; i < array.length; i++){
            maxSums[i] = Math.max(maxSums[i - 1], maxSums[i - 2] + array[i]);
        }

        return maxSums[array.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {75, 105, 120, 75, 90, 135};

        System.out.println("Max Subset Sum, No Adjacent");
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSubsetSumNoAdjacentOne(arr));
    }
}

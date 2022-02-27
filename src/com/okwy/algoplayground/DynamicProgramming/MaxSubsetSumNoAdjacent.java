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


    private static int maxSubsetSumNoAdjacentTwo(int[] array) {
        //Time: O(n), Space: O(1)
        if(array.length == 0){
            return 0;
        }

        if(array.length == 1){
            return array[0];
        }

        int first = array[0];
        int next = Math.max(array[0], array[1]);

        for(int i = 2; i < array.length; i++){
            int current = Math.max(next, first + array[i]);
            first = next;
            next = current;
        }

        return next;
    }


    private static int maxSubsetSumNoAdjacentThree(int[] arr){
        //Time: O(n), Space: O(1)
        //---------------------------
        //we make the assumption we do not need the input array for any other thing

        //First base case
        if (arr.length == 0) return 0;

        //Re-Initialization of first array element
        arr[0] = Math.max(0, arr[0]);

        //Second base case
        if (arr.length == 1) return arr[0];

        //Re-Initialization of second array element
        arr[1] = Math.max(arr[0], arr[1]);

        //Iteration of array and accumulation of no adjacent maxsum in subsets
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);

        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {75, 105, 120, 75, 90, 135};

        System.out.println("Max Subset Sum, No Adjacent");
        System.out.println(Arrays.toString(arr));
        System.out.println(maxSubsetSumNoAdjacentOne(arr));
        System.out.println(maxSubsetSumNoAdjacentTwo(arr));
        System.out.println(maxSubsetSumNoAdjacentThree(arr));
    }
}

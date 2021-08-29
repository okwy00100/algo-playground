package com.okwy.algoplayground.Arrays;

public class MinimumSwaps {

    /**
     * Description of the problem
     * --------------------------
     * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
     * You are allowed to swap any two elements. Find the minimum number of swaps required to sort the array in ascending
     * order.
     *
     * Constraints: 1 <= arr[i] <= n
     */


    private static int minimumSwaps(int[] arr) {

        int minSwap = 0;

        for (int i = 0; i < arr.length; i++) {
            if(i+1 != arr[i]){   //ideal case scenario for an already sorted pair of consecutive array elements; if not true/valid, enter block
                int tempIndex = i;
                int tempElement = arr[i];

                while(i+1 != arr[tempIndex]){
                    tempIndex++;
                }

                arr[tempIndex] =arr[i];
                arr[i] = tempElement;
                minSwap++;
            }
        }

        return minSwap;
    }

    public static void main(String[] args) {

        int[] testArray = {7, 1, 3, 2, 4, 5, 6};

        System.out.println(">>>>>>>>>>>>>Minimum Swaps");
        System.out.println(">>>>>>>>>" + minimumSwaps(testArray));

    }
}

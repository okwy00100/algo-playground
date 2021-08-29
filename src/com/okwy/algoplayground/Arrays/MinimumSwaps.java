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
                int tempIndex = i;      //introduce temp index for tracking
                int tempElement = arr[i];  //introduce temp variable to store current element for eventual swap

                while(i+1 != arr[tempIndex]){  //check if ideal case scenario exists, if not, move tracker till you find corresponding element
                    tempIndex++;
                }

                arr[tempIndex] =arr[i];  //swappity swap, swap, swappity swap...
                arr[i] = tempElement;
                minSwap++;
            }
        }

        return minSwap;  //return
    }

    public static void main(String[] args) {

        int[] testArray = {7, 1, 3, 2, 4, 5, 6};

        System.out.println(">>>>>>>>>>>>>Minimum Swaps");
        System.out.println(">>>>>>>>>" + minimumSwaps(testArray));

    }
}

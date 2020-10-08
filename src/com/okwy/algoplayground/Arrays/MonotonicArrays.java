package com.okwy.algoplayground.Arrays;

public class MonotonicArrays {

    public static boolean isMonotonic(int[] array) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for(int i= 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                isNonDecreasing = false;
            }
            if(array[i] < array[i+1]){
                isNonIncreasing = false;
            }
        }

        return isNonDecreasing || isNonIncreasing;
    }
}

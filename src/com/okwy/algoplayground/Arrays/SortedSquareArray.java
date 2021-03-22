package com.okwy.algoplayground.Arrays;

import java.util.Arrays;

public class SortedSquareArray {

    /**
     * Description of the problem
     * --------------------------
     * Give a function that takes in a non-empty array of integers that are sorted in ascending order and returns
     * a new array of the same length with the squeares of the original integers also in ascending order
     *
     */

    private static int[] sortedSquaredArray(int[] array) {
        //A pretty basic problem
        for(int i = 0; i < array.length; i++){
            array[i] = array[i] * array[i];
        }

        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {

        int[] test = {1,2,3,5,6,8,9};
        System.out.println(">>>The input array>>>>" + Arrays.toString(test));
        System.out.println(">>>>The square array>>>>" + Arrays.toString(sortedSquaredArray(test)));
    }
}

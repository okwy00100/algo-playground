package com.okwy.algoplayground.algoclasses;

import java.util.Arrays;

public class BubbleSort {


    public static int[] bubbleSortOne(int[] array) {
        //Time complexity - O(n^2)
        //Space complexity - O(1)
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swapValues(array, i, i + 1);
                    isSorted = false;
                }
            }
        }

        return array;
    }

    public static void swapValues(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static int[] bubbleSortTwo(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = i +1; j < array.length; j++){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {7, 2, 3, 5, 1, 9, 2, 8};
        System.out.println(">> Unsorted Array >>" + Arrays.toString(unsortedArray));
        System.out.println(">> The Sorted Array >>" + Arrays.toString(bubbleSortOne(unsortedArray)));
        System.out.println(">> The Sorted Array >>" + Arrays.toString(bubbleSortTwo(unsortedArray)));

    }
}

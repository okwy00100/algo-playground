package com.okwy.algoplayground.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        //Time complexity - O(n^2)
        //Space complexity - O(1)
        if(array.length == 0){
            return new int[] {};
        }

        int startIndex = 0;
        while(startIndex < array.length - 1){
            int smallestIndex = startIndex;
            for(int i = startIndex + 1; i < array.length; i++){
                if(array[i] < array[smallestIndex]){
                    smallestIndex = i;
                }
            }
            int temp = array[smallestIndex];
            array[smallestIndex] = array[startIndex];
            array[startIndex] = temp;

            startIndex++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] unsortedArray = {7, 2, 3, 5, 1, 9, 2, 8};
        System.out.println(">> Unsorted Array >>" + Arrays.toString(unsortedArray));
        System.out.println(">> Sorted Array >>" + Arrays.toString(selectionSort(unsortedArray)));
    }

}

package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergedSortedArrayMedian {


    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double median = 0.0;

        int[] mergedArray = mergeArray(nums1, nums2);

        median = mergedArray.length % 2 != 0 ? mergedArray[mergedArray.length / 2]
                : (double) (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;


        return median;
    }

    private static int[] mergeArray(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];

        //initialize counters to traverse the two arrays separately
        int counter1 = 0, counter2 = 0, temp = 0;

        //As long as both arrays are within bounds during traversal, do this else break
        while (counter1 < nums1.length && counter2 < nums2.length) {

            if (nums1[counter1] < nums2[counter2]) {
                System.out.println("true");
                arr[temp++] = nums1[counter1++];
            } else {
                System.out.println("false");
                arr[temp++] = nums2[counter2++];
            }
        }

        //finish up remnants of first array first since it was given preferrence from initial condition
        while (counter1 < nums1.length) {
            arr[temp++] = nums1[counter1++];
        }

        while (counter2 < nums2.length) {
            arr[temp++] = nums2[counter2++];
        }


        return arr;
    }



    private static double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {

        List<Integer> arr = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            arr.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++){
            arr.add(nums2[j]);
        }

        Collections.sort(arr);

        if(arr.size()%2 != 0)
            return (double) arr.get(arr.size()/2);


        return (double) (arr.get(arr.size()/2) + arr.get(arr.size()/2 - 1))/2;

    }

    public static void main(String[] args) {

//        int[] nums1 = {1,2}, nums2 = {3,4};


        int[] nums1 = {10, 22, 45, 100}, nums2 = {11, 3, 4};

        System.out.println(">>>>>>>>>>>>" + findMedianSortedArrays(nums1, nums2));
        System.out.println(">>>>>>>>>>>>" + findMedianSortedArraysBruteForce(nums1, nums2));
    }
}

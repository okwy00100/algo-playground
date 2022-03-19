package com.okwy.algoplayground.Arrays;

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

    public static void main(String[] args) {

//        int[] nums1 = {1,2}, nums2 = {3,4};


        int[] nums1 = {10, 22, 45, 100}, nums2 = {11, 3, 4};

        System.out.println(">>>>>>>>>>>>" + findMedianSortedArrays(nums1, nums2));
    }
}

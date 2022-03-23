package com.okwy.algoplayground.Interviews.Yelp;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {


    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     *
     * Example 1:
     * Input: nums = [3,2,1,5,6,4], k = 2
     * Output: 5
     *
     * Example 2:
     * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
     * Output: 4
     *
     * */


    ////////////////////////////////////////////////////////////////////////////////////////////

    // Brute Force
    // Time: O(N log N)
    // Space: O(1)
    private static int findKthLargestOne(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];

    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    // Heap utilization
    // Time: O(N log k)
    // Space: O(k)
    private static int findKthLargestTwo(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : nums){
            heap.offer(i);
            System.out.println(heap);
            if(heap.size() > k) heap.poll();
        }

        return heap.peek();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////


    // Selection Sort
    // Time: O(N log k)
    // Space: O(k)
    private static int findKthLargestThree(int[] nums, int k) {

        return 0;
    }



    ////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        int[] test = {3,2,3,1,2,4,5,5,6};

        int index = 4;

        System.out.println(findKthLargestTwo(test, index));

        System.out.println(findKthLargestOne(test, index));

    }
}

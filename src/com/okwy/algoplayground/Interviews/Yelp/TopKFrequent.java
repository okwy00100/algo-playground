package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class TopKFrequent {

    /**
     *
     * Given an integer array nums and an integer k, return the k most frequent elements.
     * You may return the answer in any order.
     *
     *
     * Example 1:
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     * */

    public static int[] topKFrequent(int[] nums, int k) {

        //base case if the most frequent query is equal to length of array
        // O(1) time
        if(k == nums.length){
            return nums;
        }

        //next for normal cases, first we create a map to store each elements against the frequency
        // O(N) time
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        //initialize a heap with 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));


        // keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(int i : count.keySet()){
            heap.add(i);
            if(heap.size() > k) heap.poll();
        }


        // build an output array
        // O(k log k) time
        int[] output = new int[k];
        for(int i = k - 1; i >=0; i--){
            output[i] = heap.poll();
        }


        return output;
    }



    public static void main(String[] args) {

        int[] test = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(test, k)));

    }
}

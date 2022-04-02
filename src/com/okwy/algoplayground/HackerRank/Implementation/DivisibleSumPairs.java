package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.Arrays;
import java.util.List;

public class DivisibleSumPairs {
    /**
     *
     * Given an array of integers and a positive integer k, determine the number of (i,j) pairs where
     * i<j and ar[i] + ar[j]  is divisible by k.
     *
     * Example
     *
     * ar = [1,2,3,4,5,6]
     * k = 5
     *
     *
     * Three pairs meet the criteria:[1,4], [2,3] and [4,6].
     *
     * Function Description
     *
     * Complete the divisibleSumPairs function in the editor below.
     *
     * divisibleSumPairs has the following parameter(s):
     *
     * int n: the length of array
     * int ar[n]: an array of integers
     * int k: the integer divisor
     * Returns
     * - int: the number of pairs
     *
     * Input Format
     *
     * The first line contains 2 space-separated integers, n and k.
     * The second line contains n space-separated integers, each a value of arr[i] .
     * */


    private static int divisibleSumPairs(int k, List<Integer> ar) {
        // Write your code here
        int[] bucket = new int[k];
        int count = 0;
        for (int value : ar) {
            int modValue = value % k;
            count += bucket[(k - modValue) % k]; // adds # of elements in complement bucket
            bucket[modValue]++;                  // saves in bucket
        }
        return count;

    }


    public static void main(String[] args) {

        int k = 5;

        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(divisibleSumPairs(k, input));
    }
}

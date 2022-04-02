package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.Arrays;
import java.util.List;

public class PickingNumbers {


    /**
     * Given an array of integers, find the longest subarray where the absolute difference between any two elements is
     * less than or equal to 1.
     *
     * Example
     *
     * a = [1,1,2,2,4,4,5,5,5]
     *
     * There are two subarrays meeting the criterion: [1,1,2,2] and [4,4,5,5,5]. The maximum length subarray has 5 elements.
     *
     * Function Description
     *
     * Complete the pickingNumbers function in the editor below.
     *
     * pickingNumbers has the following parameter(s):
     *
     * int a[n]: an array of integers
     *
     *
     * Returns
     *
     * int: the length of the longest subarray that meets the criterion
     *
     *
     * Input Format
     *
     * The first line contains a single integer , the size of the array a .
     * The second line contains  space-separated integers, each an a[i].
     *
     * Sample Input 0
     * 6
     * 4 6 5 3 3 1
     *
     *
     * Sample Output 0
     * 3
     *
     *
     *
     * */


    public static int pickingNumbers(List<Integer> a) {
        int[] frequency= new int[101];
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < a.size(); i++) {
            int index=a.get(i);
            frequency[index]++; //frequency[index]=frequency[index]+1
        }

        for (int i = 1; i <= 100; i++) {
            result = Math.max(result, frequency[i] + frequency[i - 1]);
        }
        return result;

    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(4, 6, 5, 3, 3, 1);


        System.out.println(">>>>>" + pickingNumbers(input));

    }
}

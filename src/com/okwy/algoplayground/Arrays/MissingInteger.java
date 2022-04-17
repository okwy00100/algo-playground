package com.okwy.algoplayground.Arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author okwy_nwachukwu
 * created on 4/15/22 inside the package - com.okwy.algoplayground.Arrays
 * project: algo-playground
 */

public class MissingInteger {

    /**
     *
     * Write a function:
     *
     * class Solution { public int solution(int[] A); }
     * that, given an array A of N integers, returns the smallest positive integer (greater than 0)
     * that does not occur in A.
     *
     * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     *
     * Given A = [1, 2, 3], the function should return 4.
     *
     * Given A = [−1, −3], the function should return 1.
     * Assume that:
     *
     * N is an integer within the range [1..100,000]; each element of array A is an integer within the range
     * [−1,000,000..1,000,000]. Complexity:
     *
     * expected worst-case time complexity is O(N); expected worst-case space complexity is O(N) (not counting the
     * storage required for input arguments).
     *
     * */

    private static int missingInteger(int[] A) {
        int smallestMissingInteger = 1;
        if (A.length == 0) {
            return smallestMissingInteger;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        while (set.contains(smallestMissingInteger)) {
            smallestMissingInteger++;
        }
        return smallestMissingInteger;
    }



    public static void main(String[] args) {
        int[] input = {1, 3, 6, 4, 1, 2};

        System.out.println(missingInteger(input));
    }

}

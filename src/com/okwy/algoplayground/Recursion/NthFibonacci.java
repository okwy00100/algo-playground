package com.okwy.algoplayground.Recursion;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacci {

    /**
     * Description of the problem
     * --------------------------
     * Give a function that takes in an integer n and returns the nth Fibonacci number defined by the function
     *  F(n) = (n-1) + (n-2) where the first and second numbers starting the series are 0 and 1 respectively
     *
     */

    ////////////////////////////////////////////////////////

    /**
     * Brute force Recursion
     */
    private static int getNthFibBruteForce(int n) {
        //Time: O(2^n), Space: O(n)
        if (n == 0 || n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return getNthFibBruteForce(n - 1) + getNthFibBruteForce(n - 2);
        }
    }

    ////////////////////////////////////////////////////////

    /**
     * Memoization Technique
     */

    private static int getNthFibMemoization(int n) {
        //Time: O(n), Space: O(n)
        Map<Integer, Integer> memoize = new HashMap<>();

        memoize.put(1, 0);
        memoize.put(2, 1);

        return getNthFibMemoizationHelper(n, memoize);
    }

    private static int getNthFibMemoizationHelper(int number, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(number)) {
            return memoize.get(number);
        } else {
            memoize.put(number, getNthFibMemoization(number - 1) + getNthFibMemoization(number - 2));
            return memoize.get(number);
        }
    }

    ////////////////////////////////////////////////////////

    /**
     * Counter Technique
     */

    private static int getNthFibCounter(int n) {
        //Time: O(n), Space: O(1)

        int[] fibPairs = {0, 1};
        int counter = 3;

        while (n >= counter) {
            int nextFib = fibPairs[0] + fibPairs[1];
            fibPairs[0] = fibPairs[1];
            fibPairs[1] = nextFib;
            counter++;
        }

        return n <= 1 ? fibPairs[0] : fibPairs[1];
    }


    ////////////////////////////////////////////////////////


    public static void main(String[] args) {

        //System.out.println(getNthFibBruteForce(47));
        //System.out.println(getNthFibMemoization(47));
        System.out.println(getNthFibCounter(47));

    }
}

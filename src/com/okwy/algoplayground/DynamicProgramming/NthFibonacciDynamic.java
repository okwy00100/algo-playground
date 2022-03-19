package com.okwy.algoplayground.DynamicProgramming;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.HashMap;
import java.util.Map;

public class NthFibonacciDynamic {

    /**
     * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence,
     * such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
     * <p>
     * F(0) = 0, F(1) = 1
     * F(n) = F(n - 1) + F(n - 2), for n > 1.
     * Given n, calculate F(n).
     */


    //Time - O(2^n); Space - O(n)
    private static int fibonacciBruteForce(int n) {

        if (n <= 1) return n;

        return fibonacciBruteForce(n - 1) + fibonacciBruteForce(n - 2);

    }

    ///////////////////////////////////////////////////////////////////////////////////////////


    //Time - O(n); Space - O(n)
    private static int fibonacciTabulation(int n) {

        //Using a bottom up approach (iteration)

        if (n <= 1) return n;

        int[] cache = new int[n + 1];
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];

    }

    ///////////////////////////////////////////////////////////////////////////////////////////


    //Time - O(n); Space - O(n)
    private static int fibonacciMemoization(int n) {

        //Using a top down approach (recursion)

        Map<Integer, Integer> cache = new HashMap<>();

        if (n <= 1) return n;

        return fibonacciMemoizationHelper(n, cache);

    }

    private static int fibonacciMemoizationHelper(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n, fibonacciMemoization(n - 1) + fibonacciMemoization(n - 2));
        return cache.get(n);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////



    //Time - O(n); Space - O(n)
    private static int fibonacciTabulationOptimized(int n) {

        //Using an optimized bottom up approach (iteration)

        if(n <= 1) return n;

        //base cases
        int current = 0; //n
        int first = 1;  //n-1
        int next = 0;   //n-2

        for(int i = 2; i <= n; i++){
            current = first + next;
            next = first;
            first = current;
        }

        return current;

    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        int n = 20;

//        System.out.println(">>>>>>>>>>Brute force>>>> " + fibonacciBruteForce(n));
        System.out.println(">>>>>>>>>>Tabluation>>>> " + fibonacciTabulation(n));
//        System.out.println(">>>>>>>>>>Memoization>>>> " + fibonacciMemoization(n));
        System.out.println(">>>>>>>>>>Tabluation Optimized>>>> " + fibonacciTabulationOptimized(n));


    }
}

package com.okwy.algoplayground.Recursion;

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
     * */
    private static int getNthFibBruteForce(int n) {
        //Time: O(2^n), Space: O(n)
        if(n == 0 || n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else{
            return getNthFibBruteForce(n - 1) + getNthFibBruteForce(n - 2);
        }
    }

    ////////////////////////////////////////////////////////
    /**
     * Memoization Technique
     * */

    private static int getNthFibMemoization(int n) {
        //Time: O(n), Space: O(n)

        return -1;
    }

    ////////////////////////////////////////////////////////
    /**
     * Counter Technique
     * */

    private static int getNthFibCounter(int n) {
        //Time: O(n), Space: O(1)

        return -1;
    }


    ////////////////////////////////////////////////////////


    public static void main(String[] args) {

    }
}

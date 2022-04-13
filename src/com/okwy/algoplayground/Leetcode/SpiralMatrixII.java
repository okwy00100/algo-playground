package com.okwy.algoplayground.Leetcode;

import java.util.Arrays;

/**
 * @author okwy_nwachukwu
 * created on 4/13/22 inside the package - com.okwy.algoplayground.Leetcode
 * project: algo-playground
 */

public class SpiralMatrixII {

    /**
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     *
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     *
     *
     * Example 2:
     * Input: n = 1
     * Output: [[1]]
     *
     * */


    private static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }
        return result;
    }



    public static void main(String[] args) {
        int input = 100000;

        int[][] output = generateMatrix(input);

        for(int i = 0; i < output.length; i++){
            System.out.println(Arrays.toString(output[i]) + " ");
        }

    }
}

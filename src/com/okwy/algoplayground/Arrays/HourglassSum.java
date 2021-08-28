package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HourglassSum {


    /**
     * Description of the problem
     * --------------------------
     * Give a 6x6 2D array, an hourglass is a subset of values with indices with resemblance to a typical 3x3 hourglass.
     * <p>
     * In the aforementioned 6x6 array, there are sixteen hourglasses. Calculate the su in each hourglass and print out
     * the maximum hourglass sum
     * <p>
     * Constraints:
     * Given the array, arr[i][j];
     * 0 <= i,j <= 5
     * -9 <= arr[i][j] <= 9
     */

    private static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = -64; //Because the minimum it could be is -9*7 = -63
        int startCol = 0;

        int matrix[][] = new int[6][6];
        //Read in:
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                matrix[i][j] = arr.get(i).get(j);
            }
        }


        //Each iteration of the outer loop is one hourglass
        for (int row = 0; row < 4; row++) { // this count is due to the fact we can only have 16 hourglasses hence 4 counts on the outer loop
            int sum = 0; //Initialize this specific hourglass' sum

            for (int col = startCol; col < startCol + 3; col++) {
                sum += matrix[row][col]; //Gets current value on the index that the column and row are on

                if (col == startCol) { //Only doing it if it's on the startCol ensures we only add middle piece once
                    sum += matrix[row + 1][startCol + 1];
                }

                sum += matrix[row + 2][col]; //Gets the corresponding index in the bottom row
            }

            startCol = (startCol < 3) ? startCol + 1 : 0; // If there is space for another hourglass in this row, goto the next Column


            if (startCol != 0) { //If there is space for another hourglass in this row, continue in the same row
                row--;             //You need to decrement in order to do this because for loop will increment
            }

            if (sum > maxSum) {
                maxSum = sum;
            } //keeps track of what the maximum sum is so we can print it at the end
        }

//        System.out.println(maxSum);

        return maxSum;

    }


    public static void main(String[] args) {

        List<List<Integer>> testList = new ArrayList<>();
        testList.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        testList.add(Arrays.asList(0, 1, 0, 0, 0, 0));
        testList.add(Arrays.asList(1, 1, 1, 0, 0, 0));
        testList.add(Arrays.asList(1, 1, 2, 4, 4, 0));
        testList.add(Arrays.asList(0, 0, 0, 2, 0, 0));
        testList.add(Arrays.asList(0, 0, 1, 2, 4, 0));

        System.out.println("Maximum Hourglass sum>>>>>>>>>>>>>");
        System.out.println(hourglassSum(testList));
    }
}

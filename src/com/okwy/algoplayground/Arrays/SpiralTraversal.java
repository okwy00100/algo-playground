package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    //Time complexity - O(n)
    //Space complexity - O(n)

    //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /***
     * Recursive solution
     * */

    private static List<Integer> spiralTraverseRecursive(int[][] array) {
        if (array.length == 0) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        spiralArrayGenerator(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }

    @SuppressWarnings("Duplicates")
    private static void spiralArrayGenerator(int[][] array, int startrow, int endrow, int startcolumn,
                                            int endcolumn, ArrayList<Integer> result) {
        if (startrow > endrow || startcolumn > endcolumn) {
            return;
        }

        for (int column = startcolumn; column <= endcolumn; column++) {
            result.add(array[startrow][column]);
        }

        for (int row = startrow + 1; row <= endrow; row++) {
            result.add(array[row][endcolumn]);
        }

        for (int column = endcolumn - 1; column >= startcolumn; column--) {
            if (startrow == endrow) break; // check for horizontal rectangular matrix eg 4x3
            result.add(array[endrow][column]);
        }

        for (int row = endrow - 1; row >= startrow + 1; row--) {
            if (startcolumn == endcolumn) break; //check for vertical rectangular matrix eg 3x4
            result.add(array[row][startcolumn]);
        }

        spiralArrayGenerator(array, startrow + 1, endrow - 1, startcolumn + 1, endcolumn - 1, result);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /***
     * Iterative solution
     * */
    @SuppressWarnings("Duplicates")
    private static List<Integer> spiralTraverseIterative(int[][] array) {

        if (array.length == 0) return new ArrayList<>();

        int begincolumn = 0;
        int finishcolumn = array[0].length - 1;
        int beginrow = 0;
        int finishrow = array.length - 1;

        List<Integer> result = new ArrayList<>();
        while (begincolumn <= finishcolumn && beginrow <= finishrow) {
            for (int column = begincolumn; column <= finishcolumn; column++) {
                result.add(array[beginrow][column]);
            }

            for (int row = beginrow + 1; row <= finishrow; row++) {
                result.add(array[row][finishcolumn]);
            }

            for (int column = finishcolumn - 1; column >= begincolumn; column--) {
                if (beginrow == finishrow) break;
                result.add(array[finishrow][column]);
            }

            for (int row = finishrow - 1; row >= beginrow + 1; row--) {
                if (begincolumn == finishcolumn) break;
                result.add(array[row][begincolumn]);
            }

            begincolumn++;
            finishcolumn--;
            beginrow++;
            finishrow--;
        }

        return result;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {

//        int[][] array = {
//                {4, 2, 3, 6, 7, 8, 1, 9, 5, 10},
//                {12, 19, 15, 16, 20, 18, 13, 17, 11, 14}
//        };

        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };


        List<Integer> arrayOne = spiralTraverseIterative(array);
        List<Integer> arrayTwo = spiralTraverseRecursive(array);

        for(Integer a : arrayOne){
            System.out.println(a);
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");

        for(Integer a : arrayTwo){
            System.out.println(a);
        }

    }
}

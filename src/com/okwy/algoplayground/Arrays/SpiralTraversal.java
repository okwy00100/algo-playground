package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {

    //recursive solution
    public static List<Integer> spiralTraverse(int[][] array) {
        if(array.length == 0) return new ArrayList<Integer>();

        ArrayList<Integer> result = new ArrayList<Integer>();
        spiralArrayGenerator(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }


    public static void spiralArrayGenerator(int[][] array,
                                            int startrow,
                                            int endrow,
                                            int startcolumn,
                                            int endcolumn,
                                            ArrayList<Integer> result){

        if(startrow > endrow || startcolumn >endcolumn){
            return;
        }

        for(int column = startcolumn; column <= endcolumn; column++){
            result.add(array[startrow][column]);
        }

        for(int row = startrow + 1; row <= endrow; row++){
            result.add(array[row][endcolumn]);
        }

        for(int column = endcolumn - 1; column >= startcolumn; column--){
            if(startrow == endrow) break; // check for horizontal rectangular matrix eg 4x3
            result.add(array[endrow][column]);
        }

        for(int row = endrow - 1; row >= startrow + 1; row--){
            if(startcolumn == endcolumn) break; //check for vertical rectangular matrix eg 3x4
            result.add(array[row][startcolumn]);
        }

        spiralArrayGenerator(array, startrow +1, endrow - 1, startcolumn +1, endcolumn - 1, result);

    }


    public static void main(String[] args) {

    }
}

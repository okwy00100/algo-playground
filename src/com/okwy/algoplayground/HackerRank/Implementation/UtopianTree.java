package com.okwy.algoplayground.HackerRank.Implementation;

public class UtopianTree {
    /**
     * The Utopian Tree goes through 2 cycles of growth every year. Each spring, it doubles in height. Each summer, its height increases by 1 meter.
     *
     * A Utopian Tree sapling with a height of 1 meter is planted at the onset of spring. How tall will the tree be after n growth cycles?
     *
     * For example, if the number of growth cycles is n = 5, the calculations are as follows:
     *
     * Period  Height
     * 0          1
     * 1          2
     * 2          3
     * 3          6
     * 4          7
     * 5          14
     *
     * Given a period, calculate and return the height after n cycles
     *
     * */

    public static int utopianTree(int n) {
        // Write your code here
        int result = 1;
        for(int i = 1; i <= n; i++){
            if(i % 2 != 0){
                result *= 2;
            }else{
                result++;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        int n = 5;

        System.out.println(">>>>>" + utopianTree(n));
    }
}

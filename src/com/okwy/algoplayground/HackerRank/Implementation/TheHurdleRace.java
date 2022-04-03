package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.Arrays;
import java.util.List;

public class TheHurdleRace {

    /**
     *
     * A video player plays a game in which the character competes in a hurdle race. Hurdles are of varying heights,
     * and the characters have a maximum height they can jump. There is a magic potion they can take that will increase
     * their maximum jump height by 1 unit for each dose. How many doses of the potion must the character take to be able
     * to jump all of the hurdles. If the character can already clear all of the hurdles, return 0.
     *
     * Ex:
     * ---
     * height = [1,2,3,3,2]
     * k = 1;
     *
     * The character can jump 1 unit high initially and must take 3-1 = 2 doses of potion to be able to jump all of the hurdles.
     * */


    public static int hurdleRace(int k, List<Integer> height) {
        // Write your code here
        int max = 0;

        for(Integer i : height){
            max = Math.max(max, i);
        }

        return k > max ? 0 : max - k;
    }



    public static void main(String[] args) {

        int k = 7;
        List<Integer> input = Arrays.asList(2, 5, 4, 5, 2);

        System.out.println(">>>>>>" + hurdleRace(k, input));
    }
}

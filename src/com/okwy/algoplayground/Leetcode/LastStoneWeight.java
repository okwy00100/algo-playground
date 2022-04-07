package com.okwy.algoplayground.Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    /**
     *
     * You are given an array of integers stones where stones[i] is the weight of the ith stone.
     *
     * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together.
     * Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
     *  - If x == y, both stones are destroyed, and
     *  - If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
     *
     * At the end of the game, there is at most one stone left.
     *
     * Return the smallest possible weight of the left stone. If there are no stones left, return 0.
     *
     *
     *
     * Example 1:
     *
     * Input: stones = [2,7,4,1,8,1]
     * Output: 1
     * Explanation:
     * We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
     * we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
     * we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
     * we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
     *
     *
     * Example 2:
     *
     * Input: stones = [1]
     * Output: 1
     *
     * */


    private static int lastStoneWeightFirstAttempt(int[] stones) {

        int n = stones.length;

        int[] temp = stones;
        int[] newTemp = stones;

        while(n > 0){
            Arrays.sort(temp);

            newTemp = new int[n];
            if(temp[temp.length - 1] != temp[temp.length - 2]){
                if(temp[temp.length - 1] < temp[temp.length - 2])
                    temp[temp.length - 2] = temp[temp.length - 2] - temp[temp.length - 1];
                else
                    temp[temp.length - 2] = temp[temp.length - 1] - temp[temp.length - 2];
                n--;
            }else{
                n-=2;
            }

            System.arraycopy(temp, 0, newTemp, 0, n);

        }

        return newTemp.length > 0 ? newTemp[0] : 0;
    }


    private static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<stones.length; i++) {
            pq.add(stones[i]);
        }

        for(int i=0; i<stones.length; i++) {
            if(pq.size() >= 2) {
                int a = pq.remove();
                int b = pq.remove();

                if(a!=b) {
                    pq.add(Math.abs(a-b));
                }
            } else if(pq.size() == 1) {
                return pq.peek();
            }
        }
        return 0;

    }




    public static void main(String[] args) {

//        int[] stones = {2,7,4,1,8,1};

//        int[] stones = {2,2};

        int[] stones = {3,7,8};

        System.out.println(lastStoneWeight(stones));
    }
}

package com.okwy.algoplayground.algoclasses.Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TwoNumberSumRevisited {


    public static void twoNumberSumRevisited(int[] numArray, int targetSum) {
        //Time complexity - O(nlog(n))
        //Space complexity - O(1)
        int[][] sumPairs, indexPairs;
        Arrays.sort(numArray);
        int leftPointer = 0;
        int rightPointer = numArray.length - 1;
        while (leftPointer < rightPointer) {
            int currentSum = numArray[leftPointer] + numArray[rightPointer];
            if(currentSum == targetSum){

            }else if(currentSum > targetSum){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }

        System.out.println(Arrays.toString(new int[]{numArray[leftPointer], numArray[rightPointer]}));

    }


    public static void main(String[] args) {
        // write your code here
        int[] numArray = new int[]{2, 3, 4, 1, 5, 6};
        int sum = 7;

        System.out.println(">> numArray.length >>" + numArray.length);
        System.out.println(">> Target Sum >>" + sum);
        twoNumberSumRevisited(numArray, sum);
    }
}

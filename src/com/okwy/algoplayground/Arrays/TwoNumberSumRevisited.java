package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoNumberSumRevisited {

    //To find all possible sum pairs for a target sum in an array

    public static List<int[]> twoNumberSumRevisitedOne(int[] numArray, int targetSum) {
        //Time complexity - O(nlog(n))
        //Space complexity - O(1)
        List<int[]> sumPairs = new ArrayList<>();
        Arrays.sort(numArray);
        int leftPointer = 0;
        int rightPointer = numArray.length - 1;
        while (leftPointer < rightPointer) {
            int currentSum = numArray[leftPointer] + numArray[rightPointer];
            if(currentSum == targetSum){
                int[] pairs = new int[]{numArray[leftPointer], numArray[rightPointer]};
                sumPairs.add(pairs);
                leftPointer++;
                rightPointer--;
            }else if(currentSum > targetSum){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }

        return sumPairs;

    }

    public static List<int[]> twoNumberSumRevisitedTwo(int[] numArray, int targetSum){
        //Time complexity - O(n^2)
        //Space complexity - O(1)
        List<int[]> sumPairs = new ArrayList<>();
        for(int i = 0; i < numArray.length - 1; i++){
            for(int j = i + 1; j < numArray.length; j++){
                if(numArray[i] + numArray[j] == targetSum){
                    int[] pairs = new int[]{numArray[i], numArray[j]};
                    sumPairs.add(pairs);
                }
            }
        }
        return sumPairs;
    }


    public static void main(String[] args) {
        // write your code here
        int[] numArray = new int[]{2, 3, 4, 1, 5, 6};
        int sum = 7;

        System.out.println(">> numArray.length >>" + numArray.length);
        System.out.println(">> Target Sum >>" + sum);
        List<int[]> twoNumberSumsOne = twoNumberSumRevisitedOne(numArray, sum);
        List<int[]> twoNumberSumsTwo = twoNumberSumRevisitedTwo(numArray, sum);
        System.out.println("-------------One-------------------");
        for(int[] pairs : twoNumberSumsOne){
            System.out.println(Arrays.toString(pairs));
        }
        System.out.println("-------------Two-------------------");
        for(int[] pairs : twoNumberSumsTwo){
            System.out.println(Arrays.toString(pairs));
        }

    }
}

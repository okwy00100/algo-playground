package com.okwy.algoplayground.algoclasses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {


    public static int[] twoNumberSumFirst(int[] numArray, int targetSum) {
        //Time complexity - O(n^2)
        //Space complexity - O(1)
        for (int i = 0; i < numArray.length - 1; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[i] + numArray[j] == targetSum) {
                    return new int[]{numArray[i], numArray[j]};
                }
            }
        }
        return new int[0];

    }

    public static int[] twoNumberSumSecond(int[] numArray, int targetSum) {
        //Time complexity - O(n)
        //Space complexity - O(n)
        Set<Integer> numberCollection = new HashSet<>();
        for (int num : numArray) {
            int difference = targetSum - num;
            if (numberCollection.contains(difference)) {
                return new int[]{num, difference};
            } else {
                numberCollection.add(num);
            }
        }

        return new int[0];

    }

    public static int[] twoNumberSumThird(int[] numArray, int targetSum) {
        //Time complexity - O(nlog(n))
        //Space complexity - O(1)
        Arrays.sort(numArray);
        int leftPointer = 0;
        int rightPointer = numArray.length - 1;
        while (leftPointer < rightPointer) {
            int currentSum = numArray[leftPointer] + numArray[rightPointer];
            if(currentSum == targetSum){
                return new int[]{numArray[leftPointer], numArray[rightPointer]};
            }else if(currentSum > targetSum){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }

        return new int[0];

    }


    public static void main(String[] args) {
        // write your code here
        int[] numArray = new int[]{2, 3, 4, 1, 5, 6};
        int sum = 7;

        System.out.println(">> numArray.length >>" + numArray.length);
        System.out.println(">> Target Sum >>" + sum);
        System.out.println(">> Two Sum Array >>" + Arrays.toString(twoNumberSumFirst(numArray, sum)));
        System.out.println(">> Two Sum Array >>" + Arrays.toString(twoNumberSumSecond(numArray, sum)));
        System.out.println(">> Two Sum Array >>" + Arrays.toString(twoNumberSumThird(numArray, sum)));
    }
}

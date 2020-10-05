package com.okwy.algoplayground.algoclasses.Arrays;

import java.util.*;

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

    public static int[] twoNumberSumFourth (int[] numArray, int targetSum){
        //Most Optimal in most situations involving slight problem deviation (eg Ice Cream Parlor)
        //Time complexity - O(n)
        //Space complexity - O(n)
        Map<Integer, Integer> numCollection = new HashMap<>(); //here (K,V) -> (the number itself, the number's index in the array)
        for(int i = 0; i < numArray.length; i++) {
            int num = numArray[i];
            int difference = targetSum - num;

            Integer mapNumberIndex = numCollection.get(difference);
            if(mapNumberIndex != null){
                return new int[]{numArray[mapNumberIndex],num};
            }
            numCollection.put(num, i);
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
        System.out.println(">> Two Sum Array >>" + Arrays.toString(twoNumberSumFourth(numArray, sum)));
    }
}

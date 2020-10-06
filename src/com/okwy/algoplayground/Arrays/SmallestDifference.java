package com.okwy.algoplayground.Arrays;

import java.util.Arrays;

public class SmallestDifference {

    public static int[] smallestDifferenceOne(int[] arrayOne, int[] arrayTwo) {
        //Time complexity - O(n^2)
        //Space complexity - O(1)

        int smallestDiff = Integer.MAX_VALUE;
        int[] diffPairs = new int[]{};
        for (int i = 0; i < arrayOne.length; i++){
            for(int j = 0; j < arrayTwo.length; j++){
                if(Math.abs(arrayOne[i]-arrayTwo[j]) < smallestDiff){
                    smallestDiff = Math.abs(arrayOne[i]-arrayTwo[j]);
                    diffPairs = new int[]{arrayOne[i], arrayTwo[j]};
                }
            }
        }
        return diffPairs;
    }

    public static int[] smallestDifferenceTwo(int[] arrayOne, int[] arrayTwo) {
        //Time complexity - O(nLog(n) + mLog(m)) - where m,n -> the length of both arrays.
        //                  Also the initial sorting algorithm takes O(nLog(n)) so this takes precedence
        //                  when factoring total time complexity taken
        //Space complexity - O(1)

        //First sort the arrays
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        //Next initialize the pointer variables for both arrays
        int arrayOneIndex = 0;
        int arrayTwoIndex = 0;
        //Next we initialize the variables to track the smallest difference
        //and current difference as infinty
        int smallestDiff = Integer.MAX_VALUE;
        int currentDiff = Integer.MAX_VALUE;
        //Finally we declare the array we intend to return with the pair
        //that give the smallest difference
        int[] diffPairs = new int[2];

        //while we are within the range of both arrays
        while(arrayOneIndex < arrayOne.length && arrayTwoIndex < arrayTwo.length){
            //Initialize the values at each index during the traversal
            int firstNumber = arrayOne[arrayOneIndex];
            int secondNumber = arrayTwo[arrayTwoIndex];
            if(firstNumber < secondNumber){
                currentDiff = secondNumber - firstNumber;
                arrayOneIndex++; //this is done so we can get the possible smallest diff
            }else if(firstNumber > secondNumber){
                currentDiff = firstNumber - secondNumber;
                arrayTwoIndex++; //this is done so we can get the possible smallest diff
            }else{
                //if the numbers are equal, nothing else to do. Return.
                return new int[]{firstNumber, secondNumber};
            }
            //to keep track of the smallest diff
            if(currentDiff < smallestDiff){
                smallestDiff = currentDiff;
                diffPairs = new int[]{firstNumber, secondNumber};
            }
        }

        return diffPairs;
    }
}

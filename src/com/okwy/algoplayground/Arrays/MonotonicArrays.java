package com.okwy.algoplayground.Arrays;

public class MonotonicArrays {

    public static boolean isMonotonic(int[] array) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for(int i= 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                isNonDecreasing = false;
            }
            if(array[i] < array[i+1]){
                isNonIncreasing = false;
            }
        }

        return isNonDecreasing || isNonIncreasing;
    }

    public static void main(String[] args) {
        int[] arrayOne = {1,2,3,4,5,6,7,8,9};
        int[] arrayTwo = {9,8,7,6,5,4,2,-20,-1000};
        int[] arrayThree = {1,2,1,4,5,6,7,8,9};
        int[] arrayFour = {2,2,3,4,5,6,7,8,9};
        int[] arrayFive = {1,2,3,4,5,6,7,8,-10000};
        int[] arraySix = {1,1,1,1,1,1};

        System.out.println(">>>>>>>>Array One>>>>>>>>>>>>" + isMonotonic(arrayOne));
        System.out.println(">>>>>>>>Array Two>>>>>>>>>>>>" + isMonotonic(arrayTwo));
        System.out.println(">>>>>>>>Array Three>>>>>>>>>>>>" + isMonotonic(arrayThree));
        System.out.println(">>>>>>>>Array Four>>>>>>>>>>>>" + isMonotonic(arrayFour));
        System.out.println(">>>>>>>>Array Five>>>>>>>>>>>>" + isMonotonic(arrayFive));
        System.out.println(">>>>>>>>Array Six>>>>>>>>>>>>" + isMonotonic(arraySix));
    }
}

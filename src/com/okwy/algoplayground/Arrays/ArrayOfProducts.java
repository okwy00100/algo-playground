package com.okwy.algoplayground.Arrays;

import java.util.Arrays;

public class ArrayOfProducts {


    private static int[] arrayOfProductsOne(int[] array) {
        // Time: O(n^2); Space: O(n)
        int[] products = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int runningProduct = 1;
            for (int j = 0; j < array.length; j++){
                if(i != j){
                    runningProduct *= array[j];
                }
                products[i] = runningProduct;
            }
        }

        return products;
    }


    private static int[] arrayOfProductsTwo(int[] array){
        // Time: O(n); Space: O(n)
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        int rightRunningProduct = 1;

        for(int i = 0; i < array.length; i++){
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        for(int i = array.length-1; i >= 0; i--){
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        for(int i = 0; i < array.length; i++){
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }


    public static void main(String[] args) {
        int[] inputArray = {7, 2, 3, 5, 1, 9, 2, 8};
        System.out.println(">> Input Array >>" + Arrays.toString(inputArray));
        System.out.println(">> Output Array (1) >>" + Arrays.toString(arrayOfProductsOne(inputArray)));
        System.out.println(">> Output Array (2) >>" + Arrays.toString(arrayOfProductsTwo(inputArray)));
    }
}

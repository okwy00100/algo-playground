package com.okwy.algoplayground.Arrays;

import java.util.Arrays;

public class ArrayOfProducts {


    public static int[] arrayOfProductsOne(int[] array) {
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



    public static void main(String[] args) {
        int[] inputArray = {7, 2, 3, 5, 1, 9, 2, 8};
        System.out.println(">> Input Array >>" + Arrays.toString(inputArray));
        System.out.println(">> Output Array >>" + Arrays.toString(arrayOfProductsOne(inputArray)));
    }
}

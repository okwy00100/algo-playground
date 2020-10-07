package com.okwy.algoplayground.Arrays;

import java.util.List;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEndList(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;
        while(left < right){
            while(left < right && array.get(right) == toMove){
                right--;
            }
            if(array.get(left) == toMove){
                int temp = array.get(left);
                array.set(left, array.get(right));
                array.set(right, temp);
            }
            left++;
        }


        return array;
    }


    public static int[] moveElementToEndArray(int[] array, int toMove) {
        int left = 0;
        int right = array.length - 1;
        while(left < right){
            while(left < right && array[right] == toMove){
                right--;
            }
            if(array[left] == toMove){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
            left++;
        }


        return array;
    }
}

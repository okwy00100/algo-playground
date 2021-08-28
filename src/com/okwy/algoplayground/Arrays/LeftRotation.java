package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {


    /**
     * Description of the problem
     * --------------------------
     * A left rotation operation on an array shifts each of the array's elements 1 unit to the left.
     * For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].
     * Note that the lowest index item moves to the highest index in a rotation. This is called a circular array.
     * <p>
     * Given an array a of n integers and a number, d, perform d left rotations on the array. Return the updated array
     * to be printed as a single line of space-separated integers.
     */

    private static List<Integer> rotateLeftUsingHelper(List<Integer> a, int d) {
        // Write your code here
        Integer[] numArray = new Integer[a.size()];
        a.toArray(numArray);

        System.out.println("Numarray Before Rotate Helper>>>>>>>>>>>>>>>>" + Arrays.toString(numArray));

        leftRotateHelper(numArray, 0, d - 1);
        System.out.println("Numarray After Rotate Helper phase 1>>>>>>>>>>>>>>>>" + Arrays.toString(numArray));

        leftRotateHelper(numArray, d, numArray.length - 1);
        System.out.println("Numarray After Rotate Helper phase 2>>>>>>>>>>>>>>>>" + Arrays.toString(numArray));

        leftRotateHelper(numArray, 0, numArray.length - 1);
        System.out.println("Numarray After Rotate Helper phase 3>>>>>>>>>>>>>>>>" + Arrays.toString(numArray));

        return Arrays.asList(numArray);

    }


    private static List<Integer> rotateLeftUsingArrayCopy(List<Integer> a, int d) {
        // Write your code here

        Integer[] srcNumArray = new Integer[a.size()];
        Integer[] destNumArray = new Integer[a.size()];


        a.toArray(srcNumArray);

        System.out.println("Source Numarray Before Array Copy>>>>>>>>>>>>>>>>" + Arrays.toString(srcNumArray));
        System.out.println("Destination Numarray Before Array Copy>>>>>>>>>>>>>>>>" + Arrays.toString(destNumArray));

        System.arraycopy(srcNumArray, d, destNumArray, 0, a.size() - d);

        System.out.println("Source Numarray After Array Copy 1>>>>>>>>>>>>>>>>" + Arrays.toString(srcNumArray));
        System.out.println("Destination Numarray After Array Copy 1>>>>>>>>>>>>>>>>" + Arrays.toString(destNumArray));

        System.arraycopy(srcNumArray, 0, destNumArray, a.size()-d, d);

        System.out.println("Source Numarray After Array Copy 2>>>>>>>>>>>>>>>>" + Arrays.toString(srcNumArray));
        System.out.println("Destination Numarray After Array Copy 2>>>>>>>>>>>>>>>>" + Arrays.toString(destNumArray));

        return Arrays.asList(destNumArray);

    }


    private static void leftRotateHelper(Integer[] a, int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start++] = a[end];
            a[end--] = temp;

        }

    }

    public static void main(String[] args) {

        List<Integer> test = Arrays.asList(1, 2, 3, 4, 5);


        //Test to see what the left rotate helper really does
        Integer[] numArray = {1, 2, 3, 4, 5, 6};
        Integer d = 4;

        System.out.println(">>>>>>>>>" + test);
//        System.out.println("\nNumarray After Rotate Helper phase 3>>>>>>>>>>>>>>>>" + rotateLeftUsingHelper(test, 4));
        System.out.println("\nNumarray After Rotate Array Copy>>>>>>>>>>>>>>>>" + rotateLeftUsingArrayCopy(test, 4));

    }
}

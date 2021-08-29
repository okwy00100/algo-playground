package com.okwy.algoplayground.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {

    /**
     * Description of the problem
     * --------------------------
     * <p>
     * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the
     * array element between two given indices, inclusive. Once all operations have been performed, return the maximum
     * value in the array.
     * <p>
     * arrayManipulation has the following parameters:
     * <p>
     * int n - the number of elements in the array
     * int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
     * <p>
     * <p>
     * Consider n = 10, and queries is shown below
     * <p>
     * a b k
     * 1 5 3
     * 4 8 7
     * 6 9 1
     * <p>
     * Add the values of k between the indices a and b inclusive:
     * we have:
     * <p>
     * index->	 1 2 3  4  5 6 7 8 9 10
     *          [0,0,0, 0, 0,0,0,0,0, 0]
     *          [3,3,3, 3, 3,0,0,0,0, 0]
     *          [3,3,3,10,10,7,7,7,0, 0]
     *          [3,3,3,10,10,8,8,8,1, 0]
     * <p>
     * The largest value is 10 after all operations are performed.
     */


    private static long arrayManipulationBruteForce(int n, List<List<Integer>> queries) {
        // time: O(n * m) // where n is the number of rows and m is the default number of columns(3)

        long[] morphArray = new long[n]; //new array

        for (List<Integer> query : queries) {   // loop through queries list so we can concentrate on each individual operation list(a, b, k)
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            for (int j = a - 1; j < b; j++) {   // after assigning each corresponding operation per variable, we perform the operation for each element in the morphArray
                morphArray[j] += k;             // which is adding k to all elements from morphArray[a] to morphArray[b] from the illustration above
            }
        }


        return getMaximumValue(morphArray);
    }


    private static long arrayManipulationOptimized(int n, List<List<Integer>> queries){
        // time: O(n + m) // where n is the number of rows and m is the default number of columns(3)

        long[] morphArray = new long[n + 2];    //new array, extra indices for accommodating prefix sum technique

        for (List<Integer> query : queries) {   // loop through queries list so we can concentrate on each individual operation list(a, b, k)
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);

            morphArray[a] += k;        //premise for initializing the prefix sum technique: we add k ONLY to morphArray[a] as opposed to running through till morphArray[b]
            morphArray[b + 1] -= k;    //premise for initializing the prefix sum technique: likewise, we subtract k from morphArray[b] so as to have an elimination effect
                                       //during the prefix sum iteration
        }

        System.out.println(">>>>>>>>>>>> Array before morph by prefix sum" + Arrays.toString(morphArray));

        return getMaximumValueUsingPrefixSum(morphArray);
    }


    private static long getMaximumValue(long[] array){
        long sum = Long.MIN_VALUE;
        for (long value : array) {
            if (sum < value) {
                sum = Math.max(sum, value);
            }
        }

        return sum;
    }

    private static long getMaximumValueUsingPrefixSum(long[] array){
        long sum = 0;
        long max = Long.MIN_VALUE;
        for (long value : array) {
            sum += value;
            max = Math.max(sum, max);
        }

        return max;
    }



    public static void main(String[] args) {

//        List<List<Integer>> easyTestCase = new ArrayList<>();
//        easyTestCase.add(Arrays.asList(1, 5, 3));
//        easyTestCase.add(Arrays.asList(4, 8, 7));
//        easyTestCase.add(Arrays.asList(6, 9, 1));
//
//        int n = 10;


        List<List<Integer>> easyTestCase = new ArrayList<>();
        easyTestCase.add(Arrays.asList(1, 2, 100));
        easyTestCase.add(Arrays.asList(2, 5, 100));
        easyTestCase.add(Arrays.asList(3, 4, 100));

        int n = 5;






        System.out.println(">>>>>>>>>>>>Array Manipulation Maximum sum");
        System.out.println(">>>>>>>>>>>>>>>>" + arrayManipulationBruteForce(n, easyTestCase));
//        System.out.println(">>>>>>>>>>>>>>>>" + arrayManipulationOptimized(n, easyTestCase));


    }
}

package com.okwy.algoplayground.Arrays;

import java.util.Arrays;
import java.util.List;

public class NewYearChaos {


    /**
     * Description of the problem
     * --------------------------
     * It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker
     * indicating their initial position in the queue from 1 to n. Any person can bribe the person directly in front of
     * them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
     * <p>
     * Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes,
     * or, if anyone has bribed more than two people, print Too chaotic.
     * <p>
     * Example:
     * q = [1,2,3,5,4,6,7,8]
     * If person 5 bribes person 4, the queue will look like above. Only 1 bribe is required. Print 1.
     * <p>
     * q = [4,1,2,3]
     * Here, person 4 had to bribe 3 people to get to the current position. Print Too chaotic.
     */


    private static void minimumBribes(List<Integer> queue) {

        int swapCount = 0;

        for (int i = queue.size() - 1; i >= 0; i--) {
            if (queue.get(i) != i + 1) {             //if this condition is true, that means a swap has occured.
                // For this condition since we're proceeding from the back, we check the edge case first of all to
                // ensure the do not make an out of bounds exception in our comparison. (i - 1 >= 0)
                // Next we check if the immediate previous value based on position in the array/list(queue[i-1]) is
                // equal to the index's actual value(i + 1).
                // If this is valid, we can confirm that value has performed a forward swap/bribe
                if (i - 1 >= 0 && queue.get(i - 1) == i + 1) {
                    swapCount++;
                    swapValues(queue, i - 1, i);
                }
                // For this condition since we're proceeding from the back, we check the edge case first of all to
                // ensure the do not make an out of bounds exception in our comparison. (i - 2 >= 0)
                // Next we check if the previous value, two steps up front based on position in the array/list(queue[i-2]) is
                // equal to the index's actual value(i + 1).
                // If this is valid, we can confirm that value has performed a forward swap/bribe two steps up front
                else if (i - 2 >= 0 && queue.get(i - 2) == i + 1) {
                    swapCount+=2;
                    swapValues(queue, i-2, i-1);
                    swapValues(queue, i-1, i);
                }
                //Any other conditions proves overbribery has occured, hence we have a CHAOTIC situation
                else{
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }


        System.out.println(swapCount);


    }

    private static void swapValues(List<Integer> queue, int a, int b) {
        int temp = queue.get(a);
        queue.add(a, queue.get(b));
        queue.add(b, temp);
    }


    public static void main(String[] args) {

        List<Integer> testCases = Arrays.asList(8,1,2,3,4,5,6,7);

        minimumBribes(testCases);
    }
}

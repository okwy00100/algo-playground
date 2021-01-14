package com.okwy.algoplayground.Arrays;

public class LongestPeak {

    private static int longestPeak(int[] array) {
        //Time complexity - O(n)
        //Space complexity - O(1)
        int longestPeakLength = 0;
        int i = 1; // to start monitoring potential peaks, we start from the second element in the array
        while (i < array.length - 1) { //we loop through to the penultimate element in the array
            //first we check all elements if they are a potential peak point, if the element is not,
            // we start over after moving forward by an element

            // if(array[i]<array[i+1] || array[i]<array[i-1]){
            // 	i++;
            // 	continue;
            // }

            boolean isPeak = array[i] > array[i + 1] && array[i] > array[i - 1];
            if (!isPeak) {
                i++;
                continue;
            }

            //From here, we have a potential peak. Now we proceed to get the length of the potential peak
            int leftIndex = i - 2;
            while (leftIndex >= 0 && array[leftIndex] < array[leftIndex + 1]) {
                leftIndex--;
            }

            int rightIndex = i + 2;
            while (rightIndex < array.length && array[rightIndex] < array[rightIndex - 1]) {
                rightIndex++;
            }

            // since rightindex and leftindex are both one
            // index ahead/before the edge of the peak, we have
            //length = (rightindex-1) -(leftindex+1) + 1
            int currentPeakLength = rightIndex - leftIndex - 1;
            if (longestPeakLength < currentPeakLength) {
                longestPeakLength = currentPeakLength;
            }

            i = rightIndex; //to resume the traversal, we set our peakcounter pointer to the rightindex.
            // We do this because we know simply traversing to the right once will always
            // yield isPeak == false because the left adjacennt value will always be
            // greater than the value.
        }

        return longestPeakLength;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};

        System.out.println(">>>>>>>>>>>" + longestPeak(array));
    }
}



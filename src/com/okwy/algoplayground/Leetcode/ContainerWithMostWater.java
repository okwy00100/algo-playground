package com.okwy.algoplayground.Leetcode;

public class ContainerWithMostWater {
    /**
     *
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
     * of the ith line are (i, 0) and (i, height[i]).
     *
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     *
     * Return the maximum amount of water a container can store.
     *
     * Notice that you may not slant the container.
     *
     * Example 1:
     * -----------
     * Input: height = [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
     * water (blue section) the container can contain is 49.
     *
     * Example 2:
     * ----------
     * Example 2:
     *
     * Input: height = [1,1]
     * Output: 1
     * */


    private static int maxAreaBruteForce(int[] height) {
        // List<Integer> areas = new ArrayList<>();
        int maxArea = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i + 1; j < height.length; j++){
                maxArea = Math.max(maxArea, Math.min(height[i],height[j]) * (j - i));
            }
        }
        return maxArea;
    }

    private static int maxAreaTwoPointer(int[] height) {
        int i = 0, j = height.length - 1;
        int amount = 0;
        while (i < j) {
            amount = Math.max(amount, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return amount;
    }



    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};

//        System.out.println(maxAreaBruteForce(input));
        System.out.println(maxAreaTwoPointer(input));

    }
}

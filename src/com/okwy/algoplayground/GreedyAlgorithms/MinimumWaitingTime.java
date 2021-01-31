package com.okwy.algoplayground.GreedyAlgorithms;

import java.util.Arrays;

public class MinimumWaitingTime {

    private static int minimumWaitingTime(int[] queries) {
        //Time: (O(nlogn)), Space: (O(1))
        if (queries.length == 0 || queries.length == 1) {
            return 0;
        }

        Arrays.sort(queries);

        int totalWaitingTime = 0;

        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - i - 1;
            totalWaitingTime += duration * queriesLeft;
        }

        return totalWaitingTime;
    }

    public static void main(String[] args) {
        int[] query = {3, 2, 1, 2, 6};

        System.out.println("Minimum Waiting Time");
        System.out.println("Queries: " + Arrays.toString(query));
        System.out.println(minimumWaitingTime(query));
    }
}

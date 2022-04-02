package com.okwy.algoplayground.HackerRank.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BreakingTheRecords {

    /**
     * Maria plays college basketball and wants to go pro. Each season she maintains a record of her play.
     * She tabulates the number of times she breaks her season record for most points and least points in a game.
     * Points scored in the first game establish her record for the season, and she begins counting from there.
     * <p>
     * Example
     * <p>
     * Scores are in the same order as the games played. She tabulates her results as follows:
     * <p>
     * Count
     * Game  Score  Minimum  Maximum   Min Max
     * 0      12     12       12       0   0
     * 1      24     12       24       0   1
     * 2      10     10       24       1   1
     * 3      24     10       24       1   1
     * Given the scores for a season, determine the number of times Maria breaks her records for most and least
     * points scored during the season.
     * <p>
     * Function Description
     * <p>
     * Complete the breakingRecords function in the editor below.
     * <p>
     * breakingRecords has the following parameter(s):
     * <p>
     * int scores[n]: points scored per game
     * Returns
     * <p>
     * int[2]: An array with the numbers of times she broke her records. Index  is for breaking most points records,
     * and index  is for breaking least points records.
     */


    private static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> records = new ArrayList();
        int recordsMin = 0, recordsMax = 0;
        int min = scores.get(0);
        int max = scores.get(0);

        for (int i = 1; i < scores.size(); i++) {
            if(min > scores.get(i)){
                recordsMin++;
                min = Math.min(min, scores.get(i));
            }

            if(max < scores.get(i)){
                recordsMax++;
                max = Math.max(max, scores.get(i));
            }



        }

        records.add(recordsMax);
        records.add(recordsMin);


        return records;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1);


        System.out.println(">>>>>" + breakingRecords(input));

    }
}

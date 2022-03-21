package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.List;

public class MatchUsersWithOtherTeams {

    /**
     * You are given a list of users with name and team they belong to. Now you have to match every user to one other user randomly
     * so that they can get to know each other. User match should be from different team. Find out the maximum possible match.
     * If list size is odd then you can ignore one user.
     *
     * Example - Input - [["Alex","Infra"],["Kevin","Search"],["Jill","HR"],["Jane","Infra"],["Justin","Search"],["Michael","HR"]]
     *
     * Output - [["Alex","Justin"],["Kevin","Jill"],["Jane","Michael"]]
     *
     * We dont want  ["Alex","Justin"] and ["Jane","Kevin"] combination. In that case we will left with 2 members
     * from team HR so we are wasting 2 members here.
     * */


    private static List<String[]> getMatchResult(String[][] users) {

        List<String[]> result = new ArrayList<>();

        return result;
    }

    public static void main(String[] args) {

    }
}

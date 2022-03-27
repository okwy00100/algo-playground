package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

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


    private static List<List<String>> getMatchResultOne(String[][] users) {

        List<List<String>> result = new ArrayList<>();

        //Create a map for department to queue/heap for each staff
        Map<String, Queue<String>> map = new HashMap<>();

        for(String[] user : users){
            map.putIfAbsent(user[1], new LinkedList<>());
            map.get(user[1]).offer(user[0]);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) -> map.get(b).size() - map.get(a).size());

        maxHeap.addAll(map.keySet());

        while(maxHeap.size() > 1){
            String e1 = maxHeap.poll();
            String e2 = maxHeap.poll();

            result.add(new ArrayList<>(Arrays.asList(map.get(e1).poll(), map.get(e2).poll())));

            if(map.get(e1).size() > 0) maxHeap.offer(e1);
            if(map.get(e2).size() > 0) maxHeap.offer(e2);
        }



        return result;
    }


    /////////////////////////////////////////////////////////////////////////////////////

    private static List<List<String>> getMatchResultTwo(String[][] users) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(String[] u : users) {
            map.putIfAbsent(u[1], new LinkedList<>());
            map.get(u[1]).offer(u[0]);
        }
        Queue<Map.Entry<String, Queue<String>>> maxHeap = new PriorityQueue<>((a, b)->b.getValue().size() - a.getValue().size());
        maxHeap.addAll(map.entrySet());
        List<List<String>> res = new ArrayList<>();
        while(maxHeap.size() > 1) {
            Map.Entry<String, Queue<String>> e1 = maxHeap.poll();
            Map.Entry<String, Queue<String>> e2 = maxHeap.poll();
            res.add(new ArrayList<>(Arrays.asList( e1.getValue().poll(), e2.getValue().poll())));
            if(e1.getValue().size() > 0)
                maxHeap.offer(e1);
            if(e2.getValue().size() > 0)
                maxHeap.offer(e2);
        }
        return res;
    }

    public static void main(String[] args) {

        List<List<String>> input = new ArrayList<>();
        String[][] inputArray = {{"Alex","Infra"},{"Kevin","Search"},{"Jill","HR"},{"Jane","Infra"},{"Justin","Search"},{"Michael","HR"}};

        System.out.println(">>>>>>>>>>>>" + getMatchResultOne(inputArray));
        System.out.println(">>>>>>>>>>>>" + getMatchResultTwo(inputArray));
    }
}

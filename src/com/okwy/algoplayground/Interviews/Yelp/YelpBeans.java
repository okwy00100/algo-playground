package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class YelpBeans {

    /**
     *
     */


    static class User {
        String name;
        String team;

        User(String name, String team) {
            this.name = name;
            this.team = team;
        }
    }


    static class Match {
        String first;
        String second;

        Match(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }


    private static List<Match> getMatchingPairsNoRestriction(List<User> users) {
        List<Match> result = new ArrayList<>();

        for (int i = 0; i < users.size() - 1; i += 2) {
            result.add(new Match(users.get(i).name, users.get(i+1).name));
        }
        return result;
    }


    private static List<Match> getMatchingPairsNoSameTeam(List<User> users) {
        List<Match> result = new ArrayList<>();

        Map<String, Queue<String>> map = new HashMap<>();

        for(User user : users){
            map.putIfAbsent(user.team, new LinkedList<>());
            map.get(user.team).offer(user.name);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) -> map.get(b).size() - map.get(a).size());

        maxHeap.addAll(map.keySet());

        while(maxHeap.size() > 1){
            String e1 = maxHeap.poll();
            String e2 = maxHeap.poll();

            result.add(new Match(map.get(e1).poll(), map.get(e2).poll()));

            if(map.get(e1).size() > 0) maxHeap.offer(e1);
            if(map.get(e2).size() > 0) maxHeap.offer(e2);
        }



        return result;
    }


    public static void main(String[] args) {

        List<User> input = new ArrayList<>();

        input.add(new User("John", "Infra"));
        input.add(new User("Diane", "Infra"));
        input.add(new User("Peter", "HR"));
        input.add(new User("Sam", "HR"));
        input.add(new User("Hanma", "Cloud"));
        input.add(new User("Yujiro", "Cloud"));
        input.add(new User("Jack", "Deck"));
        input.add(new User("Amy", "Deck"));
        input.add(new User("Zack", "Engineering"));
        input.add(new User("Cody", "Engineering"));


//        List<Match> test = getMatchingPairsNoRestriction(input);
        List<Match> test = getMatchingPairsNoSameTeam(input);

        for (Match m : test) {
            System.out.println(String.format("%s & %s", m.first, m.second));
        }

    }
}

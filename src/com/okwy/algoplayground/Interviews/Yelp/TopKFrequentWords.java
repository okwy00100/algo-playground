package com.okwy.algoplayground.Interviews.Yelp;

import java.util.*;

public class TopKFrequentWords {

    /**
     * Given an array of strings words and an integer k, return the k most frequent strings.
     * <p>
     * Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency
     * by their lexicographical order.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: words = ["i","love","leetcode","i","love","coding"], k = 2
     * Output: ["i","love"]
     * Explanation: "i" and "love" are the two most frequent words.
     * Note that "i" comes before "love" due to a lower alphabetical order.
     * <p>
     * <p>
     * Example 2:
     * Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
     * Output: ["the","is","sunny","day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of
     * occurrence being 4, 3, 2 and 1 respectively.
     */

    private static List<String> topKFrequentWords(List<String> words, int k) {

        List<String> output = new ArrayList<>();

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> Integer.compare(wordsMap.get(a), wordsMap.get(b)) == 0
                ? b.compareTo(a) : wordsMap.get(a).compareTo(wordsMap.get(b)));


        for(String word : wordsMap.keySet()){
            heap.add(word);
            if(heap.size() > k) heap.poll();
        }


        while(!heap.isEmpty()) output.add(0, heap.poll());

        return output;
    }


    public static void main(String[] args) {

        List<String> test = Arrays.asList("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is");
        int k = 4;

        System.out.println(topKFrequentWords(test, k));

    }
}

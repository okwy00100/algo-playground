package com.okwy.algoplayground.Strings;

import java.util.*;

public class GroupAnagrams {


    private static List<List<String>> groupAnagrams (List<String> words){
        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String word: words){
            char[] wordArray = word.toCharArray();
            Arrays.sort(wordArray);
            String sortedWord = new String(wordArray);

            if(anagramMap.containsKey(sortedWord)){
                anagramMap.get(sortedWord).add(word);
            }else{
                anagramMap.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }

        }

        return new ArrayList<>(anagramMap.values());
    }

    
    public static void main(String[] args) {
        String[] words = {"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"};
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        System.out.println("List of words");
        System.out.println(wordList);

        System.out.println("");

        System.out.println("Sorted Anagrams");
        List<List<String>> groupedAnagrams = groupAnagrams(wordList);
        System.out.println(groupedAnagrams);


    }
}

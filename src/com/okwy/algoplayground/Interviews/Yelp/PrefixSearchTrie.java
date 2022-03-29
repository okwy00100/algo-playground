package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrefixSearchTrie {

    /**
     * Given a list of business_names (strings) and a searchTerm (string).
     * Return a list of business_names that contains searchTerm as prefix in the business_names.
     ***********************************************
     * E.g.
     * Example 1.
     * Input:
     * business_names[] = { "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"}
     * searchTerm = "bur"
     *
     * Output:
     * ["burger king", "super duper burger's"]
     **********************************************
     * Example 2
     * Input:
     * business_names[] = { "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"}
     * searchTerm = "duper bur"
     *
     * Output:
     * ["super duper burger's"]
     *
     * */


    static class TrieNode {
//        char value;
//        TrieNode[] children;
//        boolean isWord;
//
//        TrieNode(char value) {
//            this.value = value;
//            this.children = new TrieNode[26];
//        }
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    class Trie{

        TrieNode root = new TrieNode();


        public void add(String word, String name){

        }



//        private static TrieNode buildTrieTree(List<String> businessNames) {
//            TrieNode root =  new TrieNode(' ');
//
//            for(String business : businessNames){
//                insert(root, business);
//            }
//
//            return root;
//        }
//
//
//
//        private static void insert(TrieNode root, String business) {
//            TrieNode node = root;
//
//            for(int i = 0; i < business.length(); i++){
//                char c = business.charAt(i);
//                if(node.children[c - 'a'] == null){
//                    node.children[c - 'a'] = new TrieNode(c);
//                }
//                node = node.children[c - 'a'];
//            }
//
//            node.isWord = true;
//
//        }
    }




    ////////////////////////////////////////////////////////////////////////////////////////////////////////////



    private static List<String> prefixSearch(List<String> businessNames, String searchTerm) {

        List<String> result = new ArrayList<>();

//        TrieNode root = buildTrieTree(businessNames);



        return result;

    }


    public static void main(String[] args) {
        List<String> test = Arrays.asList( "burger king", "McDonald's", "super duper burger's", "subway", "pizza hut");

        String searchTerm = "bur";

        System.out.println(prefixSearch(test, searchTerm));
    }
}

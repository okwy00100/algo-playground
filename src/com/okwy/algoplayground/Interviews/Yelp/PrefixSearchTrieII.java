package com.okwy.algoplayground.Interviews.Yelp;


import java.util.*;

public class PrefixSearchTrieII {

    class Node {
        HashMap<Character, Node> map = new HashMap<>();
        boolean isEnding = false;
        List<String> businessNames = new ArrayList<>();
    }

    class Trie {
        Node root = new Node();

        public void add(String word, String name) {
            char[] chars = word.toCharArray();
            Node n = root;
            for (int i = 0; i < chars.length; i++) {
                if (!n.map.containsKey(chars[i])) {
                    n.map.put(chars[i], new Node());
                }
                n = n.map.get(chars[i]);
                if (i == chars.length - 1) {
                    n.isEnding = true;
                    n.businessNames.add(name);
                }
            }
        }

        public List<String> get(String prefix) {
            List<String> res = new ArrayList<>();
            if (prefix == null | prefix.length() == 0) {
                return res;
            }

            char[] chars = prefix.toCharArray();
            Node n = root;
            for (char c : chars) {
                n = n.map.get(c);
                if (n == null) {
                    return res;
                }
            }
            HashSet<String> set = new HashSet<>();
            dfsBackTrack(n, set);
            res.addAll(set);
            return res;
        }

        private void dfsBackTrack(Node n, HashSet<String> set) {
            if (n.isEnding) {
                set.addAll(n.businessNames);
            }

            for (char c : n.map.keySet()) {
                dfsBackTrack(n.map.get(c), set);
            }
        }
    }

    public List<String> getRelatedString(List<String> businessNames, String searchTerm) {
        List<String> res = new ArrayList<>();
        if (searchTerm == null || searchTerm.isEmpty()) {
            return null;
        }
        Trie trie = new Trie();
        for (String name : businessNames) {
            String[] words = name.split(" ");
            for (String word : words) {
                trie.add(word, name);
            }
        }

        String[] terms = searchTerm.split(" ");
        HashSet<String> set = new HashSet<>();
        for (String term : terms) {
            if (set.isEmpty()) {
                set.addAll(trie.get(term));
//                System.out.println(set);
            } else {
                set.retainAll(trie.get(term));
//                System.out.println(set);
            }
        }
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        String[] input = {"burger king", "McDonald's", "super duper burger's", "subway", "pizza hut"};
        String searchTerm1 = "bur";
        String searchTerm2 = "duper bur";
        String searchTerm3 = "bur duper";
        String searchTerm4 = "r's";
        PrefixSearchTrieII ps = new PrefixSearchTrieII();
//        System.out.println(ps.getRelatedString(Arrays.asList(input), searchTerm1));
//        System.out.println(ps.getRelatedString(Arrays.asList(input), searchTerm2));
        System.out.println(ps.getRelatedString(Arrays.asList(input), searchTerm3));
        System.out.println(ps.getRelatedString(Arrays.asList(input), searchTerm4));
    }
}
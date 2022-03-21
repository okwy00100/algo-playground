package com.okwy.algoplayground.Interviews.Yelp;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionsUsingTrie {
    /**
     * You are given an array of strings products and a string searchWord.
     * <p>
     * Design a system that suggests at most three product names from products after each character of searchWord is typed.
     * Suggested products should have common prefix with searchWord. If there are more than three products with a common
     * prefix return the three lexicographically minimums products.
     * <p>
     * Return a list of lists of the suggested products after each character of searchWord is typed.
     * <p>
     * This solution is is implemented using Trie
     */


    //////////////////////////////////////////////////////////////////////////////////

    //First step, since we decide to utilize the trie approach, let us create a trie class

    class Trie {
        char value;         //value of the trie node
        Trie[] children;    //corresponding children node with respect to the current root
        boolean isWord;     //validation that current node with respect to root forms a word

        public Trie(char value) {
            this.value = value;
            this.children = new Trie[26];
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Trie root = buildTrie(products);        //second step is to build the trie tree using the list of word provided.
        // We create the method call then build it from there


        List<List<String>> result = new ArrayList<>();  // we now have to use our trie to search and
        // return top three possible suggestions for each individual letter's entry
        // in lexicographical order

        for (int i =1; i <= searchWord.length(); i++) {
            result.add(findTopThree(root, searchWord.substring(0, i)));      //for the fourth step, we do the actual top three word search,
            // using the trie tree root and the word substring
            //we create the method call then build it from there
        }


        return result;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////



    //Second step is to build the trie tree using the list of word provided.
    private Trie buildTrie(String[] products) {
        //In here we attempt to build the trie, we start with creating the root trie node and pass a space (' ')
        // to represent an empty character literal as that will be the default starting point
        Trie root = new Trie(' ');
        //Next we loop through the list of strings and insert them in our trie tree
        for (String product : products) {
            insert(product, root);          //third step we build the insert method from the call
        }

        return root;
    }

    //Third step we build the insert method
    private void insert(String product, Trie root) {
        //For insertion, we first create the node we would use for the insertion process
        Trie node = root;

        //then we iterate through the string to populate the trie tree's children nodes
        //i.e insert the word in the trie tree

        for (int i = 0; i < product.length(); i++) {
            char c = product.charAt(i);
            if (node.children[c - 'a'] == null) {             //does the letter exist in the tree
                node.children[c - 'a'] = new Trie(c);       //if yes, insert letter as a child
            }
            node = node.children[c - 'a'];                  //move to child node

        }                                                   //repeat

        node.isWord = true;                                 //on completion, congrats, you have a word
    }


    //Fourth step, we do the actual top three word search using the trie tree root and the word substring
    private List<String> findTopThree(Trie root, String word) {
        List<String> result = new ArrayList<>();
        Trie node = root;

        //First, we run through each character in the query word
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {       //if the child node is empty simply return the result(empty list)
                return result;
            } else {
                node = node.children[c - 'a'];          //else traverse the tree using the word
            }
        }

        //If the search word exists as a word, add to the list of strings to retrun as a result
        if (node.isWord) {
            result.add(word);
        }


        //Next we need to traverse through all other children in the trie tree
        for (Trie child : node.children) {
            if (child != null) {                                                //as long as each child isn't null
                List<String> dfsResult = dfs(child, word, new ArrayList<>());   //perform a dfs to each child node (fifth step)
                result.addAll(dfsResult);                                       //add the result from dfs to result list
                if (result.size() >= 3)                                         //if result size is greater than 3
                    return result.subList(0, 3);                                //return a sublist to up to 3
            }
        }


        return result;

    }


    //Fifth step - perform a dfs to each child node
    private List<String> dfs(Trie root, String word, List<String> result) {
        if(root.isWord){
            result.add(word + root.value);
            if(result.size() >= 3){
                return result;
            }
        }

        for(Trie child : root.children){
            if(child != null){
               result =  dfs(child, word + root.value, result);
            }
        }


        return result;
    }


    public static void main(String[] args) {

    }
}

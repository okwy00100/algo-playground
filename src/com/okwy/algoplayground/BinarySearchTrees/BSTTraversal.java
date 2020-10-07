package com.okwy.algoplayground.BinarySearchTrees;

import java.util.List;

public class BSTTraversal {
    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }


    //Time complexity - O(n) : Traversing every single node
    //Space complexity - O(n) : Because we store everything in an array.
    //                      If we were to print out the values, however, we would have O(d)
    //                      because our recursive calls would be stored in the call stack for each level of the tree
    public static List<Integer> inOrderTraverse(Node tree, List<Integer> array) {
        // Write your code here.
        if(tree.left != null){
            inOrderTraverse(tree.left, array);
        }
        array.add(tree.value);
        if(tree.right != null){
            inOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraverse(Node tree, List<Integer> array) {
        // Write your code here.
        array.add(tree.value);
        if(tree.left != null){
            preOrderTraverse(tree.left, array);
        }
        if(tree.right != null){
            preOrderTraverse(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraverse(Node tree, List<Integer> array) {
        // Write your code here.
        if(tree.left != null){
            postOrderTraverse(tree.left, array);
        }
        if(tree.right != null){
            postOrderTraverse(tree.right, array);
        }
        array.add(tree.value);
        return array;
    }


}

package com.okwy.algoplayground.BinaryTrees;

public class InvertBinaryTree {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    private static void invertBinaryTree(BinaryTree tree) {
        // Time: O(n) - number of nodes
        // Space: O(d) - depth of tree
        if(tree == null)
            return;

        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void main(String[] args) {
        /**
         *                        -- 10 --
         *                      /          \
         *                     5           15
         *                    /\           /\
         *                   2 5          13 22
         *                  /\             \
         *                 1                14
         *
         * */

        BinaryTree root = new BinaryTree(10);
        root.left = new BinaryTree(5);
        root.left.left = new BinaryTree(2);
        root.left.right = new BinaryTree(5);
        root.left.left.left = new BinaryTree(1);
        root.right = new BinaryTree(15);
        root.right.left = new BinaryTree(13);
        root.right.right= new BinaryTree(22);
        root.right.left.right= new BinaryTree(14);


        System.out.println(">>>>>>Invert Binary Tree >>>>>" );

    }
}

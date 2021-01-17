package com.okwy.algoplayground.BinaryTrees;

public class NodeDepthsRecursive {

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    //Time: O(n), Space: O(h)
    //Where,  n is the number of nodes
    //        h is the node height/depth
    private static int nodeDepths(BinaryTree root) {
        return calculateNodeDepths(root, 0);
    }

    private static int calculateNodeDepths(BinaryTree node, int depth) {
        if (node == null)
            return 0;

        return depth + calculateNodeDepths(node.left, depth + 1) + calculateNodeDepths(node.right, depth + 1);
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
        root.right.right = new BinaryTree(22);
        root.right.left.right = new BinaryTree(14);

        System.out.println(">>Node depth of tree>>>");
        System.out.println(nodeDepths(root));
    }
}

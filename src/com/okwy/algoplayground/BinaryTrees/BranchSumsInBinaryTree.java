package com.okwy.algoplayground.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSumsInBinaryTree {

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

    public static List<Integer> branchSums(BinaryTree root) {
        // Time: O(n), Space: O(n)
        List<Integer> sumsList = new ArrayList<>();

        calculateBranchSums(root, 0, sumsList);

        return sumsList;
    }


    private static void calculateBranchSums(BinaryTree node, int runningSum, List<Integer> sums){
        if (node == null)
            return;

        int newRunningSum = runningSum + node.value;

        if(node.left == null && node.right == null){
            sums.add(newRunningSum);
            return;
        }

        calculateBranchSums(node.left, newRunningSum, sums);
        calculateBranchSums(node.right, newRunningSum, sums);

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

        System.out.println(">>>>>>Sum of Binary Tree Branches>>>>>" );
        System.out.println(branchSums(root));
    }
}

package com.okwy.algoplayground.algoclasses;

public class BSTValidation {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static boolean validateBst(BST tree) {
        // Write your code here.
        return validateBst(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBst(BST tree, int minValue, int maxValue){
        if(tree.value < minValue || tree.value >= maxValue){
            return false;
        }
        if(tree.left != null && !validateBst(tree.left, minValue, tree.value)){
            return false;
        }
        if(tree.right != null && !validateBst(tree.right, tree.value, maxValue)){
            return false;
        }
        return true;
    }

}

package com.okwy.algoplayground.BinarySearchTrees;

import java.util.List;

public class MinimumHeightBST {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static BST minHeightBst(List<Integer> array) {
        return minHeightBSThelper(array, null, 0, array.size() -1);
    }

    public static BST minHeightBSThelper(List<Integer> array, BST bst, int startIndex, int endIndex){
        if (startIndex > endIndex){
            return null;
        }
        int midIndex = (startIndex + endIndex)/2;
        int midValue = array.get(midIndex);
        if(bst == null){
            bst = new BST(midValue);
        }else{
            bst.insert(midValue);
        }

        minHeightBSThelper(array, bst, startIndex, midIndex - 1);
        minHeightBSThelper(array, bst, midIndex + 1, endIndex);

        return bst;
    }


    public static void main(String[] args) {


    }


}

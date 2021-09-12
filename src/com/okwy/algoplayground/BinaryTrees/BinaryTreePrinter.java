package com.okwy.algoplayground.BinaryTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePrinter {

    public static class BinaryTree<T extends Comparable<?>> {
        T value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static <T extends Comparable<?>> void printBinaryTree(BinaryTree<T> root) {
        int maxLevel = BinaryTreePrinter.maxLevel(root);

        printBinaryTreeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBinaryTreeInternal(List<BinaryTree<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinter.printWhitespaces(firstSpaces);

        List<BinaryTree<T>> newBinaryTrees = new ArrayList<BinaryTree<T>>();
        for (BinaryTree<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newBinaryTrees.add(node.left);
                newBinaryTrees.add(node.right);
            } else {
                newBinaryTrees.add(null);
                newBinaryTrees.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BinaryTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinter.printWhitespaces(1);

                BinaryTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBinaryTreeInternal(newBinaryTrees, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTree<T> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinter.maxLevel(node.left), BinaryTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}

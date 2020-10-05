package com.okwy.algoplayground.algoclasses.BinarySearchTrees;

public class FindClosestValueInBST {

    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target, String type) {
        //Time complexity: O(log(N))[average] || O(N)[worst]
        //Space complexity(Recursively): O(log(N))[average] || O(N)[worst]
        //Space complexity(Iteratively): O(1)
        if(type.toLowerCase().contains("recursive")) {
            return findClosestValueInBstRecursively(tree, target, tree.value);
        }else{
            return findClosestValueInBstIteratively(tree, target, tree.value);
        }
    }


    public static int findClosestValueInBstRecursively(BST tree, int target, int closest){
        //First, we verify the closest node to our target
        // We do this by verifying if the absolute difference between the current closest node
        // and the target is less than the absolute difference between the target
        // and the the current node value we are on. If not then we update
        if(Math.abs(closest-target)>Math.abs(tree.value-target)){
            closest = tree.value;
        }
        //using the property of the BST, use the target to travel the tree and recursively check each node
        if(tree.left != null && target < tree.value){
            return findClosestValueInBstRecursively(tree.left, target, closest);
        } else if(tree.right != null && target > tree.value){
            return findClosestValueInBstRecursively(tree.right, target, closest);
        }else{
            return closest;
        }
    }


    private static int findClosestValueInBstIteratively(BST tree, int target, int closest) {
        //Similar to the recursive method, the only difference here is that we have a BST variable
        // to keep track of where we are on the tree and we simply update that variable as we traverse the tree
        BST currentNode = tree;
        while(currentNode != null){
            if(Math.abs(target-closest) > Math.abs(target-currentNode.value)){
                closest = currentNode.value;
            }
            if(target < currentNode.value){
                currentNode = currentNode.left;
            }else if(target > currentNode.value){
                currentNode = currentNode.right;
            }else{
                break;
            }
        }

        return closest;
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

        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.right= new BST(22);
        root.right.left.right= new BST(14);

        int target = 12;
        System.out.println(">>>>>>Target>>>>>" + 12);
        //System.out.println("The closest node to target is " + findClosestValueInBst(root, target,"recursive"));
        System.out.println("The closest node to target is " + findClosestValueInBst(root, target,"iterative"));


    }
}

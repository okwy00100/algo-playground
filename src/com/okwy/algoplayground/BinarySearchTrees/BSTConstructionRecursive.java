package com.okwy.algoplayground.BinarySearchTrees;

public class BSTConstructionRecursive {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node insert(int value) {
            //first, compare the value with the value of the current node
            if (value < this.value) {
                if (left == null) {
                    Node node = new Node(value);
                    left = node;
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    Node node = new Node(value);
                    right = node;
                } else {
                    right.insert(value);
                }
            }
            return this;
        }

        public boolean contains(int value) {
            //Compare value wit the value of the current node just like insertion
            if (value < this.value) {
                if (left == null) {
                    return false;
                } else {
                    return left.contains(value);
                }
            } else if (value > this.value) {
                if (right == null) {
                    return false;
                } else {
                    return right.contains(value);
                }
            } else {
                return true;
            }
        }

        public Node remove(int value) {
            remove(value, null);
            return this;
        }

        //Helper method for the Node node removal
        public void remove(int value, Node parent) {
            //If value is smaller than current node value, move left
            if (value < this.value) {
                //If left node is not null, perform recursion
                if (left != null) {
                    left.remove(value, this);
                }
                //If value is greater than current node value, move right
            } else if (value > this.value) {
                //If right node is not null perform recursion
                if (right != null) {
                    right.remove(value, this);
                }
                //If we finally arrive at the node we want to remove then we
                //do the the following checks
            } else {
                //If node has children
                if (left != null && right != null) {
                    this.value = right.getMinimumValue();
                    right.remove(this.value, this);
                    //node is an orphan
                } else if (parent == null) {
                    if (left != null) {
                        this.value = left.value;
                        right = left.right;
                        left = left.left;
                    } else if (right != null) {
                        this.value = right.value;
                        left = right.left;
                        right = right.right;
                    } else {
                        //do nothing or nullify Node
                    }
                    //If node is parent's left child
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                    //If node is parent's right child
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }
            }
        }

        public int getMinimumValue() {
            if (left == null) {
                return this.value;
            } else {
                return left.getMinimumValue();
            }
        }
    }
}

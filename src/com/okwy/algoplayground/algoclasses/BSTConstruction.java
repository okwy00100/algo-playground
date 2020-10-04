package com.okwy.algoplayground.algoclasses;

public class BSTConstruction {

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            //first, compare the value with the value of the current node
            if (value < this.value) {
                if (left == null) {
                    BST bst = new BST(value);
                    left = bst;
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    BST bst = new BST(value);
                    right = bst;
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

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        //Helper method for the BST node removal
        public BST remove(int value, BST parent) {
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
                        // do nothing
                    }
                    //If node is parent's left child
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;
                    //If node is parent's right child
                } else if (parent.right == this) {
                    parent.right = left != null ? left : right;
                }

            }
            return this;
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

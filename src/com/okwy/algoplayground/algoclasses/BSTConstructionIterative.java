package com.okwy.algoplayground.algoclasses;

public class BSTConstructionIterative {
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            BST currentNode = this;
            //first, compare the value with the value of the current node
            //Using an infinite loop to maintain the check, break when insertion has taken place
            while (true) {
                if (value < currentNode.value) {
                    if (currentNode.left == null) {
                        BST bst = new BST(value);
                        currentNode.left = bst;
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else {
                    if (currentNode.right == null) {
                        BST bst = new BST(value);
                        currentNode.right = bst;
                        break;
                    } else {
                        currentNode = currentNode.right;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;

        }

        public BST remove(int value) {
            remove(value, null);
            return this;
        }

        //Helper method for the BST node removal
        public void remove(int value, BST parentNode) {
            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    if (currentNode.left != null) {
                        parentNode = currentNode;
                        currentNode = currentNode.left;
                    }
                } else if (value > currentNode.value) {
                    if (currentNode.right != null) {
                        parentNode = currentNode;
                        currentNode = currentNode.right;
                    }
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.value = currentNode.right.getMinimumValue();
                        currentNode.right.remove(currentNode.value, currentNode);
                    } else if (parentNode == null) {
                        if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else if (currentNode.right != null) {
                            currentNode.value = currentNode.right.value;
                            currentNode.left = currentNode.right.left;
                            currentNode.right = currentNode.right.right;
                        } else {
                            //do nothing or nullify BST
                            currentNode = null;
                        }

                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
                    }
                    break;
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

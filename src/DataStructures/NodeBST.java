package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NodeBST {
    int data;
    NodeBST left, right;

    public NodeBST(final int data) {
        this.data = data;
    }

    // insert is called from the node class, how would things change if insert was
    // in a separate BST class
    public void insert(final int value) {
        if (value <= data) {
            if (left == null) {
                left = new NodeBST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new NodeBST(value);
            } else {
                right.insert(value);
            }
        }
    }

    // Ranges are inclusive, this function is linear time, space complexity is log n
    public boolean checkBST(final NodeBST root, final int min, final int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);

    }

    public boolean checkBST(final NodeBST root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean contains(final int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                right.contains(value);
            }
        }
        return false;
    }

    // In order traversal
    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    // PRE order traversal
    public void printPreOrder() {
        System.out.println(data);
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    // POST order traversal
    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.println(data);

    }
}
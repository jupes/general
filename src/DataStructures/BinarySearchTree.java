package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }

    //insert is called from the node class, how would things change if insert was in a separate BST class
    public void insert(int value) {
        if (value <= data) {
            if(left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    // Ranges are inclusive, this function is linear time, space complexity is log n
    public boolean checkBST(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data <  min || root.data > max) {
            return false;
        } 
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);

    }

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean contains(int value) {
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
    }

    // In order traversal
    public void printInOrder() {
        if(left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null) {
            right.printInOrder();
        }
    }

    // PRE order traversal
    public void printPreOrder() {
        System.out.println(data);
        if(left != null) {
            left.printPreOrder();
        }
        if(right != null) {
            right.printPreOrder();
        }
    }

    // POST order traversal
    public void printPostOrder() {
        if(left != null) {
            left.printPostOrder();
        }
        if(right != null) {
            right.printPostOrder();
        }
        System.out.println(data);
        
    }
}

//ignore
public class BinarySearchTree {
     
    public BinarySearchTree(Node node){
        this.node = node;
    }

    public void insert(int value) {
        if (value <= data) {
            if(left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } 
    }
}
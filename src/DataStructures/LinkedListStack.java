package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Implement Stack using a linked list, the code does not handle null pointers as is
 */
public class LinkedListStack {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
        }

        public boolean isEmpty() {
            return false;
        }
    }

    private Node top; // always access top first

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() {
        if(!top.isEmpty()) {
            return top.data;
        }
        return 0;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}
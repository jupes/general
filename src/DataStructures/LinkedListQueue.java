package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Implement Queue using a linked list
 */
public class LinkedListQueue {
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

    private Node head; // remove from head
    private Node tail; // add to tail

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if(!head.isEmpty()) {
            return head.data;
        }
        return 0;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }

    public int remove() {
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return data;
    }
}
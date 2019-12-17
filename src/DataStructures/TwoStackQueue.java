package DataStructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TwoStackQueue {
    public static class MyQueue<T> {
        private Stack<T> newDataStack = new Stack<T>();
        private Stack<T> oldDataStack = new Stack<T>();

        /**
         * Add item to queue
         * 
         * @param value item to be added
         */
        public void enqueue(T value) {
            newDataStack.push(value);
        }

        /**
         * Get oldest item from queue
         * @return oldest item
         */
        public T peek() {
            shiftStacks();
            return oldDataStack.peek();
        }
        
        /**
         * Move the new data into the old data if the old data is empty
         */
        public void shiftStacks() {
            if (oldDataStack.isEmpty()) {
                while(!newDataStack.isEmpty()) {
                    oldDataStack.push(newDataStack.pop());
                }
            }
        }

        /**
         * remove oldest item from queue
         * @return oldest item
         */
        public T dequeue() {
            shiftStacks();
            return oldDataStack.pop();
        }
    }
}
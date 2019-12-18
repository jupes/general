
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchantSolution {

    // Complete the sockMerchant function below.
    /**
     * This function takes two params, an array and its length. Using a hash set
     * (linear time lookup, add, and removal) we take a running count of like pairs
     * and return the total. Each time a pair is found remove that element from the
     * set so that the order of the array does not matter
     * 
     * @param n  Length of the array
     * @param ar Array of Socks
     * @return Count of pairs of like socks
     */
    static int sockMerchant(int n, int[] ar) {
        HashSet hashSet = new HashSet(n);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (hashSet.contains(ar[i])) {
                count++;
                hashSet.remove(ar[i]);
            } else {
                hashSet.add(ar[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int result = 0;

        // Test Unsorted Array
        int[] testArray1 = { 2, 1, 1, 3, 4, 5, 0, 7 };
        result = sockMerchant(testArray1.length, testArray1);
        System.out.println("Expected Result: 1, Actual Result: " + result);

        // Test Larger Unsorted Array
        int[] testArray2 = { 2, 1, 1, 3, 4, 5, 0, 7, 8, 7, 9, 3, 6, 4, 4, 7, 3, 6, 7, 8, 3, 54, 65, 6 };
        result = sockMerchant(testArray2.length, testArray2);
        System.out.println("Expected Result: 8, Actual Result: " + result);

        // Test Sorted Array
        int[] testArray3 = { 1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9 };
        result = sockMerchant(testArray3.length, testArray3);
        System.out.println("Expected Result: 9, Actual Result: " + result);
    }
}
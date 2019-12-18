//TODO: Understand why this fixed my compile time error
package HackerRank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountValleysSolution {

    // Complete the countingValleys function below.
    /**
     * This solution takes advantage of the idea that any time you end up at sea
     * level and the last check was uphill you had to have been in a valley. So for
     * each time you altitude (var alt) reaches zero from going uphill, add a valley
     * to the count
     * 
     * @param n length of the string
     * @param s represents the steps uphill and downhill
     * @return number of valleys encountered in hiking
     */
    static int countingValleys(int n, String s) {
        int valleys = 0;
        int alt = 0;
        char[] steps = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (steps[i] == 'U') {
                alt++;
                if (alt == 0) {
                    valleys++;
                }
            } else {
                alt--;
            }
        }
        return valleys;
    }

    public static void main(String[] args) {
        int result = 0;

        // Test Basic Success Case
        String testStr1 = "DU";
        result = countingValleys(testStr1.length(), testStr1);
        System.out.println("Expected Result: 1, Actual Result: " + result);

        // Test Larger String
        String testStr2 = "UDDDUDUU";
        result = countingValleys(testStr2.length(), testStr2);
        System.out.println("Expected Result: 1, Actual Result: " + result);

        // Test Case Where Multiple Valleys Encountered
        String testStr3 = "DDUUDDUDUUUD";
        result = countingValleys(testStr3.length(), testStr3);
        System.out.println("Expected Result: 2, Actual Result: " + result);
    }
}

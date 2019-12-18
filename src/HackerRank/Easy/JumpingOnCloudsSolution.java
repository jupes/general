package HackerRank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnCloudsSolution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int result = 0;
        int i = 0;
        while (i < c.length - 1) {
            if (c.length > i + 2 && c[i + 2] == 1) {
                i++;
            } else {
                i += 2;
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        int result = 0;

        // Test Unsorted Array
        int[] testArray1 = { 0, 0, 1, 0, 0, 1, 0 };
        result = jumpingOnClouds(testArray1);
        System.out.println("Expected Result: 4, Actual Result: " + result);

        // Test Larger Unsorted Array
        int[] testArray2 = { 0, 0, 0, 0, 1, 0 };
        result = jumpingOnClouds(testArray2);
        System.out.println("Expected Result: 3, Actual Result: " + result);

    }
}

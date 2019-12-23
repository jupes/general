package Algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MergeSort {
    public static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length - 1);
    }

    private static void mergesort(int[] array, int[] tmpArr, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = (left + right) / 2;
        mergesort(array, tmpArr, middle + 1, right);
        mergesort(array, tmpArr, left, middle);
        mergeHalves(array, tmpArr, left, right);
    }

    public static void mergeHalves(int[] array, int[] tmpArr, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tmpArr[index] = array[left];
                index++;
                left++;
            } else {
                tmpArr[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, tmpArr, index, leftEnd - left + 1);
        System.arraycopy(array, right, tmpArr, index, rightEnd - right + 1);
        System.arraycopy(tmpArr, leftStart, array, leftStart, size);
    }
}
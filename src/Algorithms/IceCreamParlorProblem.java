package Algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// Point of this one is to, starting with some amount of money, find a pair of unique flavors that sum to equal my total cash
public class IceCreamParlorProblem {
    public static int indexOf(int[] menu, int index, int excludeThis) {
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != excludeThis) {
                return i;
            }
        }
    }

    public static int[] getIndiciesFromValues(int[] menu, int value1, int value2) {
        int index1 = indexOf(menu, value1, -1);
        int index2 = indexOf(menu, value2, index1);
        int[] indicies = { Math.min(index1, index2), Math.max(index1, index2) };
        return indicies;
    }

    public static int[] findChoices(int[] menu, int money) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - sortedMenu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if (location >= 0 && location < menu.length && sortedMenu[location] == complement) {
                int[] indicies = getIndiciesFromValues(menu, sortedMenu[i], compliment);
                return indicies;
            }
        }
        return null;
    }
}
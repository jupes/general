package Algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

//this problem takes advantage of memoization and dynamic programming
public class MakeChangeProblem {
    // Function with fewer params to assist the caller
    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<String, Long>());
    }

    /**
     * This function returns the number of ways you can make change for a given
     * amount of money with a set of coin values
     * 
     * @param coins set of coin values that you can use to make change
     * @param money amount of money remaining
     * @param index the index in the array (set) of coins passed through the
     *              function calls to remember where in the array of coins you are
     * @param memo  hashmap of the result of the functions previously computed, so
     *              stores how many ways you can make the change for the money from
     *              pennies, nickles, etc so you dont overcompute (spend more time
     *              finding the answers to problems youve already encountered)
     * @return return the value of the number of ways you can make change with the
     *         given set and the money to be divided
     */
    public static long makeChange(int[] coins, int money, int index, HashMap<String, Long> memo) {
        // if money is zero then there is nothing to be divided, return 1 (you can get
        // zero only one way)
        if (money == 0) {
            return 1;
        }
        // if I am past the coins array index then there are no more coins to consider,
        // return zero
        if (index >= coins.length) {
            return 0;
        }
        // Set up the key in that hash map with a dash, so that "2" + "21" would not
        // collide with "22" + "1"
        String key = money + "-" + index;
        // If we have done and stored the result before, simply return the lookup
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int amountWithCoin = 0;
        long ways = 0;
        // while the amount of money used with the current coin is less than the amount remaining
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
        }
        // If i had not seen the calculation before then add the result of that to my
        // hash map
        memo.put(key, ways);
        return ways;
    }
}
package LeetCode;

import java.util.Hashtable;

// Solution to the twosum problem, scored 98.92% faster and 98.95 better space complexity amoung the 2,384,783 accepted submissions at time of writing
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Keep track of numbers Ive seen before, store the index I saw them at
        Hashtable<Integer, Integer> knownValues = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            // Find the number that would work with the one at the current index
            int compliment = target - nums[i];
            // If the number exists in the table return the index of that value and the
            // current index
            if (knownValues.get(compliment) != null) {
                return new int[] { knownValues.get(compliment), i };
            } else {
                // add value and key to table if it hasnt been encountered
                knownValues.put(nums[i], i);
            }
        }
        // no matching pair was found
        return null;
    }
}
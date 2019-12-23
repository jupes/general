package LeetCode;

import java.util.Hashtable;

// Solution to the twosum v2 problem, scored 100.0% faster and 96.27 better space complexity amoung the 321,864 accepted submissions at time of writing
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // start at the front and back of the array
        int frontIndex = 0;
        int backIndex = nums.length - 1;
        // loop through starting at the middle value (since array is sorted)
        while (frontIndex <= backIndex) {
            int front = nums[frontIndex];
            int back = nums[backIndex];
            int total = front + back;
            if (total == target) {
                return new int[] { frontIndex + 1, backIndex + 1 };
            } else if (total > target) {
                backIndex--;
            } else {
                frontIndex++;
            }
        }
        // no matching pair was found
        return null;
    }
}
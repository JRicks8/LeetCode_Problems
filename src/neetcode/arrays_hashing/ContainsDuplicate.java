package neetcode.arrays_hashing;
/*
    Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.

    Example 1:
    Input: nums = [1, 2, 3, 3]
    Output: true


    Example 2:
    Input: nums = [1, 2, 3, 4]
    Output: false
*/

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            if (!numSet.add(n)) {
                return true;
            }
        }
        return false;
    }
}
package neetcode.arrays_hashing;

import java.util.Arrays;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]



Constraints:

    2 <= nums.length <= 105
    -30 <= nums[i] <= 30
    The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.



Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


Initial Solution
public int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] answer = new int[n];
    Arrays.fill(answer, 1);
    int current = 1;
    for (int i = 0; i < n; ++i) {
        answer[i] *= current;
        current *= nums[i];
    }
    current = 1;
    for (int i = n-1; i >= 0; --i) {
        answer[i] *= current;
        current *= nums[i];
    }
    return answer;
}
 */

public class ProductOfArrayExceptSelf {
    // O(n) time complexity, O(1) extra space complexity
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int l = 1;
        int r = 1;
        int o;
        for (int i = 0; i < n; i++) {
            o = nums.length - i - 1;
            answer[i] *= l;
            l *= nums[i];
            answer[o] *= r;
            r *= nums[o];
        }
        return answer;
    }
}

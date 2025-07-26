package neetcode.arrays_hashing;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]



Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.


Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

/*
Initial solution

public int[] twoSum(int[] nums, int target) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (visit(nums, target, nums[i], i, result)) {
            result.add(i);
            break;
        }
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
}

private boolean visit(int[] nums, int target, int sum, int currentInd, ArrayList<Integer> result) {
    for (int i = currentInd + 1; i < nums.length; i++) {
        if (sum + nums[i] == target) {
            result.add(i);
            result.add(currentInd);
            return true;
        } else if (visit(nums, target, sum + nums[i], i, result)) {
            result.add(currentInd);
            return true;
        }
    }
    return false;
}
 */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Store each number in input array in a map, such that:
        // <nums[i], [target - nums[i], i]>
        // Stores value, target pair, and value index in the map
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], new Integer[]{ target - nums[i], i });
        }
        // Find results using our map
        int[] result = new int[2];
        map.forEach((k, v) -> {
            if (map.get(v[0]) != null && map.get(v[0])[0] == target - v[0]) {
                result[0] = map.get(v[0])[1];
                result[1] = v[1];
            }
        });
        // Check that we didn't use the same number twice
        if (result[0] == result[1]) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == nums[result[0]] && i != result[0]) {
                    result[0] = i;
                    break;
                }
            }
        }
        return result;
    }
}

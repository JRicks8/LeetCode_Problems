package neetcode.arrays_hashing;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        topKFrequent(new int[] {1,1,1,2,2,3}, 2);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // First, count up the occurrences of each number and put it in a map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) - 1); // Use minus one here because lower numbers get higher prio in queue
            } else {
                map.put(n, 0);
            }
        }
        // Use a priority queue. Time complexity for Java prio queue is O(log(n)) (for insertion), which beats the required time complexity.
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        map.forEach((key, value) -> queue.add(new int[]{key, value}));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}

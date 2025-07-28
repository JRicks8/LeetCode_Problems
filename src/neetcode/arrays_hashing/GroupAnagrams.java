package neetcode.arrays_hashing;

/*
Given an array of strings strs, group the

together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.
 */

/*
Initial solution
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    for (int j = 0; j < strs.length; j++) {
        int v = 17;
        for (int i = 0; i < strs[j].length(); i++) {
            v *= strs[j].charAt(i);
        }
        if (map.containsKey(v)) {
            map.get(v).add(j);
        } else {
            map.put(v, new ArrayList<>(List.of(j)));
        }
    }
    List<List<String>> result = new ArrayList<>();
    map.values().forEach(set -> {
        result.add(set.stream().map(s -> strs[s]).toList());
    });
    return result;
}
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<Map<Character, Integer>, List<Integer>> bigMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            Map<Character, Integer> m = getCharMap(strs[i]);
            if (bigMap.containsKey(m)) {
                bigMap.get(m).add(i);
            } else {
                bigMap.put(m, new ArrayList<>(List.of(i)));
            }
        }
        bigMap.values().forEach(set -> {
            result.add(set.stream().map(s -> strs[s]).toList());
        });
        return result;
    }

    private Map<Character, Integer> getCharMap(String s) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
            } else {
                m.put(s.charAt(i), 1);
            }
        }
        return m;
    }
}

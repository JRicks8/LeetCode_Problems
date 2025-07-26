package neetcode.arrays_hashing;
/*
    Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
    An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

    Example 1:
    Input: s = "racecar", t = "carrace"
    Output: true

    Example 2:
    Input: s = "jar", t = "jam"
    Output: false

    Constraints:
    s and t consist of lowercase English letters.
*/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] arr = new int[26];
        s.chars().forEach(c -> arr[c - 97]++);
        t.chars().forEach(c -> arr[c - 97]--);
        for (int n : arr) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}

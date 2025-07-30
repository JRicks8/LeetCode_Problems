package neetcode.arrays_hashing;

/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]

Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

Constraints:
0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeAndDecodeStrings {
    private static final String divider = "%FF%";

    public static String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        String result = "";
        for (int i = 0; i < strs.size(); i++) {
            result = result.concat(strs.get(i));
            if (i != strs.size() - 1) {
                result = result.concat(divider);
            }
        }
        return result;
    }

    public static List<String> decode(String str) {
        if (str == null) {
            return new ArrayList<>();
        }
        return Arrays.stream(str.split(divider)).toList();
    }
}

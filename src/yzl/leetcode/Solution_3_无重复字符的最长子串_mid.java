package yzl.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_3_无重复字符的最长子串_mid {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Set<Character> ss = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!ss.contains(s.charAt(right))) {
                ss.add(s.charAt(right));
                right++;
            } else {
                ss.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, ss.size());
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcbcabc";
        int len = new Solution_3_无重复字符的最长子串_mid().lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}

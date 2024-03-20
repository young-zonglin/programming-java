package yzl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_438_找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        // 0 1 2 3 4
        p = toSortedString(p);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String compared = toSortedString(s.substring(i, i + p.length()));
            if (p.equals(compared)) {
                result.add(i);
            }
        }
        return result;
    }

    private String toSortedString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new Solution_438_找到字符串中所有字母异位词().findAnagrams(s, p));
    }
}

class Solution_438_滑动窗口 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] window = new int[26];
        int[] target = new int[26];
        for (char c : p.toCharArray()) {
            target[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(target, window)) {
            result.add(0);
        }
        for (int left = 0, right = p.length() - 1; right < s.length() - 1; left++, right++) {
            window[s.charAt(left) - 'a']--;
            window[s.charAt(right + 1) - 'a']++;
            if (Arrays.equals(target, window)) {
                result.add(left + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new Solution_438_滑动窗口().findAnagrams(s, p));
    }
}

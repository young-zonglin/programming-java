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
        return null;
    }
}

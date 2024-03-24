package yzl.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_383_赎金信_简单 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                if (cnt > 0) {
                    cnt--;
                    map.put(c, cnt);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}

class Solution_383_two {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (char c : magazine.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (chars[c - 'a'] > 0) {
                chars[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}

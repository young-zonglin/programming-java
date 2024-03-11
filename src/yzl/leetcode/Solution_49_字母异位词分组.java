package yzl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_49_字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> cache = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String tmp = String.copyValueOf(chars);
            if (cache.containsKey(tmp)) {
                cache.get(tmp).add(s);
            } else {
                List<String> stringList = new ArrayList<>();
                stringList.add(s);
                cache.put(tmp, stringList);
            }
        }

        return new ArrayList<>(cache.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution_49_字母异位词分组().groupAnagrams(strs));
    }
}

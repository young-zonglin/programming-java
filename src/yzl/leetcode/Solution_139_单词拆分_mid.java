package yzl.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 使用回溯（DFS+剪枝）
 * 针对s=LeetCode，s可被break 等价于 前面（Leet）在字典里，且后面也可以被break（原问题和子问题）
 */
public class Solution_139_单词拆分_mid {
    // 比如aaaaab测试用例，存在重复子问题，可以用备忘录来优化递归 => 记忆化搜索
    // a在字典里，aaaab不可以被break
    private final Map<String, Boolean> memory = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        if (memory.containsKey(s)) {
            return memory.get(s);
        }
        // 边界条件
        if ("".equals(s)) return true;
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            String suffix = s.substring(i + 1);
            if (wordDict.contains(prefix) && wordBreak(suffix, wordDict)) {
                memory.put(s, true);
                return true;
            }
        }
        memory.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String test = "LeetCode";
        List<String> wordDict = Arrays.asList("Leet", "Code");
        boolean ans = new Solution_139_单词拆分_mid().wordBreak(test, wordDict);
        System.out.println(ans);
    }
}

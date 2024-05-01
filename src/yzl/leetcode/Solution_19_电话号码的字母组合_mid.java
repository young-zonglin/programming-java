package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * B站灵神讲回溯
 */
public class Solution_19_电话号码的字母组合_mid {
    private String[] path;
    private final String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        path = new String[n];
        dfs(0, n, digits, ans);
        return ans;
    }

    /*
     * 回溯三步骤：
     * 1、枚举
     * 2、子问题：dfs(i)
     * 3、下一个子问题：dfs(i+1)
     *
     * 时间复杂度：O(n*4^n)，
     * 有些数字可以映射4个字母。
     * 最后添加答案的时候，要把数组变成字符串，这里有n的时间复杂度
     */
    private void dfs(int i, int n, String digits, List<String> ans) {
        if (i == n) {
            ans.add(String.join("", path));
            return;
        }
        String curEnum = mapping[Integer.parseInt(digits.substring(i, i + 1))];
        for (int j = 0; j < curEnum.length(); j++) {
            path[i] = curEnum.substring(j, j + 1);
            dfs(i + 1, n, digits, ans);
        }
    }
}

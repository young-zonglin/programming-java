package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * B站灵神讲回溯
 */
public class Solution_17_电话号码的字母组合_mid {
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
     * 时间复杂度：O(4^n * n)
     * 有些数字可以映射4个字母 => 4^n
     * 最后添加答案的时候，要把数组变成字符串，这里有n的时间复杂度
     */
    private void dfs(int i, int n, String digits, List<String> ans) {
        // 边界条件
        if (i == n) {
            // 需要复制到ans里
            ans.add(String.join("", path));
            return;
        }
        String curEnum = mapping[Integer.parseInt(digits.substring(i, i + 1))];
        for (int j = 0; j < curEnum.length(); j++) {
            // 这里每次覆盖path[i]，所以其实也是有回溯的
            path[i] = curEnum.substring(j, j + 1);
            dfs(i + 1, n, digits, ans);
        }
    }

    public static void main(String[] args) {
        String digits = "253";
        List<String> ans = new Solution_17_电话号码的字母组合_mid().letterCombinations(digits);
        System.out.println(ans);
        System.out.println(ans.size());
    }
}

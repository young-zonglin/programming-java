package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 类似0-1背包问题，可以用二进制枚举、回溯法等
 */
public class Solution_78_子集_mid {
    private String[] path;

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        path = new String[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, ans);
        return ans;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(convert(path));
            return;
        }
        // 枚举：
        // 1. 不选
        path[i] = nums[i] + "_" + "0";
        dfs(i + 1, nums, ans);
        // 2. 选
        path[i] = nums[i] + "_" + "1";
        dfs(i + 1, nums, ans);
    }

    private List<Integer> convert(String[] path) {
        List<Integer> res = new ArrayList<>();
        for (String str : path) {
            if (str.endsWith("1")) {
                res.add(Integer.parseInt(str.split("_")[0]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new Solution_78_子集_mid().subsets(nums);
        System.out.println(ans);
    }
}

package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 回溯（递归+DFS），本质也是暴力法。。
 */
public class Solution_46_全排列_mid {
    private final List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, nums, ans);
        return ans;
    }

    /*
     * 时间复杂度：O(n*n!)
     * 空间复杂度：取决于递归的深度，即O(n)
     */
    private void dfs(int i, int[] nums, List<List<Integer>> ans) {
        // 递归先写边界条件
        if (i == nums.length) {
            // path是复用的，这里需要拷贝一下
            List<Integer> list = new ArrayList<>(path);
            ans.add(list);
            return;
        }
        // 枚举
        for (int num : nums) {
            if (path.contains(num)) continue;
            path.add(num);
            dfs(i + 1, nums, ans);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new Solution_46_全排列_mid().permute(nums);
        System.out.println(ans);
    }
}

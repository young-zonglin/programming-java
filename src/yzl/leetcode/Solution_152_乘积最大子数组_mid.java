package yzl.leetcode;

import java.util.Arrays;

public class Solution_152_乘积最大子数组_mid {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 由于乘积存在负负得正的情况，所以无法简单判断加入或者不加入就确定动态转移方程
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        // base case
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 用dp1记录最大值
            dp1[i] = Math.max(Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            // 用dp2记录最小值
            dp2[i] = Math.min(Math.min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
        }
        return Arrays.stream(dp1).max().orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        int ans = new Solution_152_乘积最大子数组_mid().maxProduct(nums);
        System.out.println(ans);
    }
}

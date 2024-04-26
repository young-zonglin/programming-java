package yzl.leetcode;

import java.util.Arrays;

public class Solution_300_最长自增子序列_mid {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 状态：以i为结尾的，最长递增子序列的长度
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            // 穷举，有点零钱兑换的感觉
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 选择
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int maxLen = new Solution_300_最长自增子序列_mid().lengthOfLIS(arr);
        System.out.println(maxLen);
    }
}

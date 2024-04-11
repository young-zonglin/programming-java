package yzl.leetcode;

import java.util.Arrays;

public class Solution_53_最大子数组和_mid {
    // 前缀和解法，会超时。。
    public int maxSubArray_timeout(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                max = Math.max(max, sums[j + 1] - sums[i]);
            }
        }
        return max;
    }

    public int maxSubArray_dp1(int[] nums) {
        // dp[i]：以i为结尾的最大子数组和，或者说最大连续子序列和
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
        }
        return Arrays.stream(nums).max().orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = new Solution_53_最大子数组和_mid().maxSubArray_timeout(nums);
        int max1 = new Solution_53_最大子数组和_mid().maxSubArray_dp1(nums);
        System.out.println("前缀和：" + max);
        System.out.println("dp1：" + max1);
    }
}

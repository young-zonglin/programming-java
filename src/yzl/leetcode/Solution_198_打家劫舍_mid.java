package yzl.leetcode;

import java.util.Arrays;

// 好文：https://zhuanlan.zhihu.com/p/98405912
/*
 * `打家劫舍`，有点类似0-1背包问题，要挑选一些房间，并且使得金额最大
 * 只不过`打家劫舍`多了些约束条件，不能选择相邻的房间
 *
 * 状态：dp[start..] 从房子索引start开始，能抢到的最大值
 * 选择：抢 或者 不抢
 * 明确了状态转移，可以写出递归解法
 */
public class Solution_198_打家劫舍_mid {
    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) return 0;
        return Math.max(
                // 不抢，去下家
                dp(nums, start + 1),
                // 抢，去下下家
                nums[start] + dp(nums, start + 2));
    }
}

/*
 * 盗贼有多种选择可以走到这个位置，所以说存在重叠子问题
 * 使用备忘录/缓存，自顶向下的DP解法
 */
class Solution_198_memory {
    private int[] memory;

    public int rob(int[] nums) {
        // 初始化备忘录
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start) {
        if (start >= nums.length) return 0;
        // 避免重复计算
        if (memory[start] != -1) return memory[start];
        int res = Math.max(dp(nums, start + 1), nums[start] + dp(nums, start + 2));
        // 存入备忘录/缓存
        memory[start] = res;
        return res;
    }
}

package yzl.leetcode;

import java.util.Arrays;

/*
 * 挺好的讲解：https://waiterxiaoyy.github.io/2020/03/24/LeetCode%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0%E2%80%94%E2%80%94%E9%9B%B6%E9%92%B1%E5%87%91%E6%95%B0%EF%BC%88%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%EF%BC%89/
 */
public class Solution_322_零钱兑换_mid {
    public int coinChange(int[] coins, int amount) {
        // 因为硬币最小面额是1，所以凑出amount其实至多需要amount枚硬币
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        // 状态：dp[i]表示凑出i金额最少需要多少枚硬币
        for (int i = 1; i <= amount; i++) {
            // 对每个子问题都穷举
            // 类似爬楼梯，少一层就是走到n-1和n-2
            // 少一枚，就是amount-coins[j]
            for (int coin : coins) {
                if (coin <= i) {
                    // 选择 or 状态转移方程
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        int minSum = new Solution_322_零钱兑换_mid().coinChange(coins, amount);
        System.out.println(minSum);
    }
}

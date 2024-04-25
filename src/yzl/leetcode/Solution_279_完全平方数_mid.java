package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 1、先找出10000以内的完全平方数
 * 2、此题和`零钱兑换`基本一样，除了初始化条件不同，因为1是完全平方数=> dp[i]=i为base case
 */
public class Solution_279_完全平方数_mid {
    private static final List<Integer> cache = new ArrayList<>();

    static {
        initSquares();
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int coin : cache) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[n];
    }

    private static void initSquares() {
        for (int i = 1; i <= 10000; i++) {
            double b = Math.sqrt(i);
            int a = (int) b;
            if (a - b == 0) {
                cache.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int ans = new Solution_279_完全平方数_mid().numSquares(7168);
        System.out.println(cache);
        System.out.println(ans);
    }
}
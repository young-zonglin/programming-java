package yzl.leetcode;

public class Solution_322 {
    public int coinChange(int[] coins, int amount) {
        int coinsLen = coins.length;
        if (coinsLen <= 0) return -1;
        int intMaxValue = Integer.MAX_VALUE-1;
        int[] sum = new int[amount+1];
        int i, j, curSum, tmpAmount;

        for (i=1; i<=amount; i++) {
            sum[i] = intMaxValue;
            for (j=0; j<coinsLen; j++) {
                if ((tmpAmount=i-coins[j])>=0 && (curSum=sum[tmpAmount]+1) < sum[i]) {
                    sum[i] = curSum;
                }
            }
        }

        return sum[amount] == intMaxValue ? -1 : sum[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{2};
        int amount = 3;
        int minSum = new Solution_322().coinChange(coins, amount);
        System.out.println(minSum);
    }
}

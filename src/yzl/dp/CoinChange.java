package yzl.dp;

import java.util.Arrays;

/**
 * Get plan of coin change.
 */
public class CoinChange {
    public int[] coinChange(int[] coins, int amount) {
        int coinsLen = coins.length;
        if (coinsLen <= 0) return new int[0];
        int intMaxValue = Integer.MAX_VALUE - 1;
        int[] sum = new int[amount+1];
        int[][] plan = new int[amount+1][amount];
        int i, j, t, curSum, tmpAmount;

        for (i=1; i<=amount; i++) {
            sum[i] = intMaxValue;
            for (j=0; j<coinsLen; j++) {
                if ((tmpAmount=i-coins[j]) >= 0 && (curSum=sum[tmpAmount]+1) < sum[i]) {
                    sum[i] = curSum;
                    for (t=0; t<curSum-1; t++) {
                        plan[i][t] = plan[tmpAmount][t];
                    }
                    plan[i][t] = coins[j];
                }
            }
        }

        int minSum = sum[amount] == intMaxValue ? 0 : sum[amount];
        int[] ret = new int[minSum];
        System.arraycopy(plan[amount], 0, ret, 0, minSum);
        return ret;
    }

    public static void main(String[] args) {
        int coins[] = new int[]{2};
        int amount = 11;
        int[] plan = new CoinChange().coinChange(coins, amount);
        System.out.println(Arrays.toString(plan));
    }
}

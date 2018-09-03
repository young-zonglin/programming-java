package yzl.leetcode;

/**
 * Get len of longest common `sub-string` between a and b.
 */
public class Solution_718 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,1,0,0,2};
        int[] b = new int[]{3,1,5,1,2};
        int lenOfLCS = new Solution_718_two().findLength(a, b);
        System.out.println(lenOfLCS);
    }
}

/**
 * Use 2D state array.
 */
class Solution_718_one {
    public int findLength(int[] A, int[] B) {
        int len_a = A.length;
        int len_b = B.length;
        int states[][] = new int[len_a+1][len_b+1];
        int maxLen = 0;

        for (int i = 1; i<=len_a; i++) {
            for (int j = 1; j<=len_b; j++) {
                if (A[i-1] == B[j-1]) {
                    states[i][j] = states[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, states[i][j]);
                }
            }
        }
        return maxLen;
    }
}

/**
 * Use 1D dp array.
 */
class Solution_718_two {
    public int findLength(int[] a, int[] b) {
        int len_a = a.length;
        int len_b = b.length;
        int dp[] = new int[len_b+1];
        int maxLen = 0;

        for (int i=1; i<=len_a; i++) {
            for (int j=len_b; j>0; j--) {
                if (a[i-1] == b[j-1]) {
                    dp[j] = dp[j-1] + 1;
                    maxLen = Math.max(maxLen, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return maxLen;
    }
}

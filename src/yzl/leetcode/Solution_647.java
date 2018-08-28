package yzl.leetcode;

/**
 * Palindromic substrings.
 */
public class Solution_647 {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        int i, j, count = 0;

        for (i=len-1; i>=0; i--) {
            for (j=0; j<len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                    count++;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (i+1 < len && j-1 >= 0) {
                        if (i+1 == j || dp[i+1][j-1] == 1) {
                            dp[i][j] = 1;
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String a = "aaaa";
        int count = new Solution_647().countSubstrings(a);
        System.out.println(count);
    }
}

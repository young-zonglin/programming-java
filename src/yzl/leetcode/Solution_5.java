package yzl.leetcode;

/**
 * Longest palindromic substrings.
 */
public class Solution_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 0) return "";
        int[][] dp = new int[len][len];
        int i, j, start=0, end=0, maxInterval=0, tmp;

        for (i=len-1; i>=0; i--) {
            for (j=0; j<len; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (s.charAt(i) == s.charAt(j)) {
                    if (i+1 < len && j-1 >= 0) {
                        if (i+1 == j || dp[i+1][j-1] == 1) {
                            dp[i][j] = 1;
                            tmp = j-i;
                            if (tmp > maxInterval) {
                                maxInterval = tmp;
                                start = i;
                                end = j;
                            }
                        }
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        String a = "babadab";
        String res = new Solution_5().longestPalindrome(a);
        System.out.println(res);
    }
}

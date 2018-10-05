package yzl.leetcode;

import java.util.Scanner;

/**
 * Factorial Trailing Zeroes
 */
public class Solution_172 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = new Solution_172().trailingZeroes(n);
        System.out.println(res);
    }

    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        int count = 0;
        int tmp = n/5;
        while (tmp != 0) {
            count += tmp;
            tmp /= 5;
        }
        return count;
    }
}

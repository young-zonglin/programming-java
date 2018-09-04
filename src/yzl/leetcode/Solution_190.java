package yzl.leetcode;

/**
 * Reverse bits.
 */
public class Solution_190 {
    public static void main(String[] args) {
        long n = Long.MAX_VALUE;
        System.out.println(n);
        System.out.println((int) n);
        int res = new Solution_190_one().reverseBits((int)n);
        System.out.println(res);
    }
}

class Solution_190_one {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1; // res *= 2
            res += n & 1;
            n >>= 1; // n /= 2
        }
        return res;
    }
}

package yzl.leetcode;

/**
 * Number of 1 bits.
 */
public class Solution_191_位1的个数 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            count += n >> i & 1;
        }
        return count;
    }
}

package yzl.leetcode;

public class Solution_461 {
    public int hammingDistance(int x, int y) {
        int hammingDist = 0;
        for (int i = 0; i < 32; i++) {
            if ((x&1) != (y&1)) {
                hammingDist++;
            }
            x >>= 1;
            y >>= 1;
        }
        return hammingDist;
    }
}

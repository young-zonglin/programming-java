package yzl.leetcode;

/**
 * Hamming distance.
 */
public class Solution_461 {

}

class Solution_461_one {
    public int hammingDistance(int x, int y) {
        int hammingDist = 0;
        for (int i = 0; i < 32; i++) {
            if ( ((x>>i)&1) != ((y>>i)&1) ) {
                hammingDist++;
            }
        }
        return hammingDist;
    }
}

class Solution_461_two {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        for (int i = 0; i<32; i++) {
            count += (num>>i)&1;
        }
        return count;
    }
}

package yzl.leetcode;

public class Solution_136_只出现一次的数字 {
    /**
     * 1、交换律：a ^ b ^ c <=> a ^ c ^ b
     * <p>
     * 2、任何数与0异或为任何数 0 ^ n => n
     * <p>
     * 3、相同的数异或为0: n ^ n => 0
     * <p>
     * 2 ^ 3 ^ 2 ^ 4 ^ 4等价于 2 ^ 2 ^ 4 ^ 4 ^ 3 => 0 ^ 0 ^3 => 3
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_136_只出现一次的数字().singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}

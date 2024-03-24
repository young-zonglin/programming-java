package yzl.leetcode;

/*
 * 三指针解法：
 * 相当于3个刷色器，
 * 第一次先把所有格子刷成蓝色，
 * 然后第二把刷子再刷白色，
 * 最后再根据红色的个数去刷红色。
 */
public class Solution_75_颜色分类 {
    public void sortColors(int[] nums) {
        int red = 0, write = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) {
                nums[blue++] = 2;
                nums[write++] = 1;
                nums[red++] = 0;
            } else if (num == 1) {
                nums[blue++] = 2;
                nums[write++] = 1;
            } else {
                nums[blue++] = 2;

            }
        }
    }
}

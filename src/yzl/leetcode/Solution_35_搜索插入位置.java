package yzl.leetcode;

public class Solution_35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }
}

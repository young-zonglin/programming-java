package yzl.leetcode;

public class Solution_26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 2, 2, 3, 3, 4};
        int valid = new Solution_26_删除有序数组中的重复项().removeDuplicates(nums);
        for (int i = 0; i < valid; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

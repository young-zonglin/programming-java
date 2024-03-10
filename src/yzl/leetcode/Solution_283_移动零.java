package yzl.leetcode;

import java.util.Arrays;

public class Solution_283_移动零 {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {0, 1, 0, 3, 12};
        new Solution_283_移动零().moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
    }
}

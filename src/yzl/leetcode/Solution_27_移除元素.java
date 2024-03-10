package yzl.leetcode;

public class Solution_27_移除元素 {
    public int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_27_移除元素().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new Solution_27_移除元素().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
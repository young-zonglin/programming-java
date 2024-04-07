package yzl.leetcode;

public class Solution_35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }
}

class Solution_35_binSearch {
    public int searchInsert(int[] nums, int target) {
        int begin = 0, end = nums.length;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            int midVal = nums[mid];
            if (midVal == target) return mid;
            else if (midVal < target) begin = mid + 1;
            else end = mid;
        }
        return begin;
    }

    public static void main(String[] args) {
        int pos = new Solution_35_binSearch().searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(pos);
    }
}

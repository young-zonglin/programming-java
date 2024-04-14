package yzl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_15_三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.println(result);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        for (int i = 0; i < len - 2; i++) {
            // i的去重处理
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] < target) left++;
                else if (nums[left] + nums[right] > target) right--;
                else {
                    Integer[] tmp = new Integer[]{nums[i], nums[left], nums[right]};
                    res.add(Arrays.asList(tmp));
                    // left的去重处理
                    while (left < len - 1 && nums[left] == nums[left + 1]) left++;
                    // right的去重处理
                    while (right > 0 && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}

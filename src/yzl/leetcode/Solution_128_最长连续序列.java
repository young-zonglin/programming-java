package yzl.leetcode;

import java.util.Arrays;

public class Solution_128_最长连续序列 {
    // 时间复杂度不是O(n)
    public int longestConsecutive_wrong(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLen = 1, curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            else if (nums[i] == nums[i - 1] + 1) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else curLen = 1;
        }
        return maxLen;
    }
}

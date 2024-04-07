package yzl.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two sum problem.
 * Just traverse the array once.
 */
class Solution_1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (cache.containsKey(complement)) {
                return new int[]{cache.get(complement), i};
            } else {
                cache.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 2, 5};
        int[] res = new Solution_1_两数之和().twoSum(arr, 6);
        System.out.println(Arrays.toString(res));
    }
}

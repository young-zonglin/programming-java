package yzl.leetcode;

import java.util.*;

/**
 * Two sum problem.
 */
public class Solution_1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 2, 5};
//        int[] res = new Solution_1_wrong().twoSum(arr, 6);
        int[] res = new Solution_1_three().twoSum(arr, 6);
        System.out.println(Arrays.toString(res));
    }
}

/**
 * Need to traverse the array twice.
 */
class Solution_1_two {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIdx = new HashMap<>();
        int i, end;
        for (i = 0; i < nums.length; i++) {
            numToIdx.put(nums[i], i);
        }
        for (i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIdx.containsKey(complement) && (end = numToIdx.get(complement)) != i) {
                return new int[]{i, end};
            }
        }
        throw new IllegalArgumentException("No two sum solution.");
    }
}

/**
 * Just traverse the array once.
 */
class Solution_1_three {
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
}

class Solution_1_wrong {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j = 1;
        for (i = 0; i < nums.length - 1; i++) {
            j = binarySearch(nums, i + 1, target - nums[i]);
            if (j >= 0) break;
        }
        if (j < 0)
            throw new IllegalArgumentException("No two sum solution.");
        return new int[]{nums[i], nums[j]};
    }

    private int binarySearch(int[] nums, int s, int key) {
        int e = nums.length - 1;
        int mid, midVal;
        while (s <= e) {
            mid = s + (e - s) / 2;
            midVal = nums[mid];
            if (midVal == key) return mid;
            else if (midVal < key) s = mid + 1;
            else e = mid - 1;
        }
        return -(s + 1);
    }
}

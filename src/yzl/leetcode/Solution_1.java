package yzl.leetcode;

import java.util.*;

public class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> numToIdxs = new HashMap<>();
        int i, end=1;
        List<Integer> idxs;
        for (i = 0; i<nums.length; i++) {
            idxs = numToIdxs.get(nums[i]);
            if (idxs == null) {
                idxs = new ArrayList<>();
                idxs.add(i);
                numToIdxs.put(nums[i], idxs);
            } else {
                idxs.add(i);
            }
        }
        for (i = 0; i<nums.length; i++) {
            if ((idxs=numToIdxs.get(target-nums[i])) != null) {
                for (int tmp : idxs) {
                    if (tmp != i) {
                        end = tmp;
                        return new int[] {i, end};
                    }
                }
            }
        }

        return new int[] {i, end};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3};
        int[] res = new Solution_1().twoSum(arr, 6);
        System.out.println(Arrays.toString(res));
    }
}

class Solution_1_wrong {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i, j=1;
        for (i = 0; i < nums.length; i++) {
            j = binarySearch(nums, i+1, target-nums[i]);
            if (nums[i]+nums[j] == target) break;
        }
        return new int[]{nums[i], nums[j]};
    }

    private int binarySearch(int[] nums, int s, int target) {
        int e = nums.length - 1;
        int mid, midValue;
        while (s < e) {
            mid = s+(e-s)/2;
            midValue = nums[mid];
            if (midValue == target) return mid;
            else if (midValue < target) s=mid+1;
            else e=mid;
        }
        return s;
    }
}

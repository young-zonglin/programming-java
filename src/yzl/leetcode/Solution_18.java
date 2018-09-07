package yzl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_18 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,-2,-5,-4,-3,3,3,5};
        int target = -11;
        List<List<Integer>> res = new Solution_18().fourSum(nums, target);
        System.out.println(res);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return ret;
        Arrays.sort(nums);
        for (int i = 0; i<len-3; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            for (int j = i+1; j<len-2; j++) {
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                int complement = target-nums[i]-nums[j];
                int m = j+1, n = len-1;
                while (m < n) {
                    if (nums[m]+nums[n] == complement) {
                        Integer tmp[] = new Integer[]{nums[i], nums[j], nums[m], nums[n]};
                        ret.add(Arrays.asList(tmp));
                        while (m<n && nums[m] == nums[m+1]) ++m;
                        while (m<n && nums[n] == nums[n-1]) --n;
                        ++m;
                        --n;
                    } else if (nums[m]+nums[n] > complement) n--;
                    else m++;
                }
            }
        }
        return ret;
    }
}

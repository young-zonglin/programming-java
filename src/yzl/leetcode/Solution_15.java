package yzl.leetcode;

import java.util.*;

public class Solution_15 {
    public static void main(String[] args) {
        int nums[] = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = new Solution_15_one().threeSum(nums);
        System.out.println(result);
    }
}

class Solution_15_one {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        int target;
        for (int i = 0; i<len-2; i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            target = -nums[i];
            int m = i+1, n=len-1;
            while (m < n) {
                if (nums[m]+nums[n] < target) ++m;
                else if (nums[m]+nums[n] > target) --n;
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    res.add(list);
                    while (m<n && nums[m] == nums[m+1]) ++m;
                    while (m<n && nums[n] == nums[n-1]) --n;
                    ++m;
                    --n;
                }
            }
        }
        return res;
    }
}

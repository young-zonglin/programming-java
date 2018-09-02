package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find all increasing sub-sequences.
 */
public class Solution_491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len <= 1) return result;

        List<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        result.add(first);
        for (int i = 1; i<len; i++) {
            List<List<Integer>> curEndIncSubSeqs = new ArrayList<>();
            for (List<Integer> list : result) {
                int size = list.size();
                if (size <= 0) continue;
                if (nums[i] >= list.get(size-1)) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(nums[i]);
                    curEndIncSubSeqs.add(tmp);
                }
            }
            List<Integer> cur = new ArrayList<>();
            cur.add(nums[i]);
            result.add(cur);
            result.addAll(curEndIncSubSeqs);
        }
        result = result.stream().filter(list -> list.size()>=2).distinct().collect(Collectors.toList());
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 6, 7};
        List<List<Integer>> result = new Solution_491().findSubsequences(arr);
        System.out.println(result);
    }
}

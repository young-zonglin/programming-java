package yzl.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Total hamming distance.
 */
public class Solution_477 {
    public static void main(String[] args) {
        int[] nums = new int[]{51, 52, 51, 52};
        int totalDist = new Solution_477_one().totalHammingDistance(nums);
        System.out.println(totalDist);
    }
}

/**
 * This solution will time out.
 */
class Solution_477_one {
    public int totalHammingDistance(int[] nums) {
        int len = nums.length, totalHammingDist = 0;
        Map<Set<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i<len; i++) {
            for (int j = i+1; j<len; j++) {
                if (nums[i] != nums[j]) {
                    Set<Integer> curr = new HashSet<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    if (map.containsKey(curr)) {
                        totalHammingDist += map.get(curr);
                    } else {
                        int dist = hammingDist(nums[i], nums[j]);
                        map.put(curr, dist);
                        totalHammingDist += dist;
                    }
                }
            }
        }

        return totalHammingDist;
    }

    private int hammingDist(int x, int y) {
        int dist = 0;
        for (int i = 0; i < 32; i++) {
            if (((x>>i)&1) != ((y>>i)&1)) {
                dist++;
            }
        }
        return dist;
    }
}

class Solution_477_two {
    public int totalHammingDistance(int[] nums) {
        int totalDist = 0;
        for (int i = 0; i<32; i++) {
            int oneCount = 0;
            for (int j = 0; j<nums.length; j++) {
                oneCount += nums[j]&1;
                nums[j] >>= 1;
            }
            totalDist += oneCount * (nums.length-oneCount);
        }
        return totalDist;
    }
}

class Solution_477_three {
    public int totalHammingDistance(int[] nums) {
        int totalDist = 0;
        for (int i = 0; i<32; i++) {
            int oneCount = 0;
            for (int num : nums) {
                oneCount += (num >> i)&1;
            }
            totalDist += oneCount * (nums.length-oneCount);
        }
        return totalDist;
    }
}

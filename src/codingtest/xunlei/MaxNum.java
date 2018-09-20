package codingtest.xunlei;

import java.util.Arrays;
import java.util.Scanner;

public class MaxNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        int max = new MaxNum().maxNum(nums);
        System.out.print(max);
    }

    public int maxNum(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i<nums.length; i++) {
            maxCount = Math.max(maxCount, count(nums, i));
        }
        return maxCount;
    }

    private int count(int nums[], int idx) {
        int len = nums.length;
        if (idx >= len) return 0;
        else if (idx >= len-2) return nums[idx]<0 ? 0 : nums[idx];
        if (nums[idx] < 0) nums[idx] = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 2; i<len-idx; i++) {
            int curCount = nums[idx] + count(nums, idx+i);
            if (curCount > maxCount) maxCount = curCount;
        }
        return maxCount;
    }
}

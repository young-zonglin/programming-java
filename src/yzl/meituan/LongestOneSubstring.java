package yzl.meituan;

import java.util.Scanner;

/**
 * Meituan coding test.
 * Exhaustion solution.
 * It will time out.
 */
public class LongestOneSubstring {
    public int getLongestLen(int[] nums, int try_) {
        int len = nums.length;
        int count, times, maxLen=0;
        for (int i = 0; i<len; i++) {
            count = 0;
            times = try_;
            for (int j=i; j<len; j++) {
                if (nums[j] == 1) count++;
                else if (times > 0) {
                    count++;
                    times--;
                } else break;
            }
            if (count > maxLen) {
                maxLen = count;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        int nums[] = new int[n];
        int try_ = reader.nextInt();
        for (int i = 0; i<n; i++) {
            nums[i] = reader.nextInt();
        }
        int maxLen = new LongestOneSubstring().getLongestLen(nums, try_);
        System.out.println(maxLen);
    }
}

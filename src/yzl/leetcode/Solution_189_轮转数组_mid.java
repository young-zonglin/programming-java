package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_189_轮转数组_mid {
    // 使用额外空间，性能也比较慢
    // TODO 使用O(1)原地算法
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            deque.add(num);
        }
        for (int i = 0; i < k; i++) {
            int tmp = deque.removeLast();
            deque.addFirst(tmp);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = deque.removeFirst();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution_189_轮转数组_mid().rotate(nums, 10);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution_189_cool {
    // 先复制为2倍，再取k-n开始
    // 1 2 3 4 5 6 7  1 2 3 4 5 6 7
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] twiceNums = new int[n << 1];
        System.arraycopy(nums, 0, twiceNums, 0, n);
        System.arraycopy(nums, 0, twiceNums, n, n);
        System.arraycopy(twiceNums, n - k, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution_189_cool().rotate(nums, 10);
        System.out.println(Arrays.toString(nums));
    }
}

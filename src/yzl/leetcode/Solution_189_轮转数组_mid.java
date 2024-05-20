package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_189_轮转数组_mid {
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

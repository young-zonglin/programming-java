package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_239_滑动窗口最大值_hard {
    /*
     * 知乎好文：https://zhuanlan.zhihu.com/p/346354943
     * “如果一个选手比你小还比你强，你就可以退役了。”——单调队列的原理
     * 时间复杂度：O(n)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 递减序列，解决区间最大值问题
        // 这个递减序列的真实含义：越老且越强 > 越年轻且越弱
        // deque里存储的只是索引而已
        Deque<Integer> deque = new ArrayDeque<>();
        // ans里存储的是区间最大值
        int[] ans = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            // 毕业
            if (!deque.isEmpty() && i - deque.getFirst() >= k) {
                deque.removeFirst();
            }
            // 比新生弱的都当场退役（求区间最小值把这里改成>即可）
            // 易错点1：deque里只是索引，所以要比较的其实是nums[index]
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            // 新生入队
            deque.add(i);

            if (i >= k - 1) {
                // 易错点2：ans存储的是区间最值，而不是索引。。
                ans[j++] = nums[deque.getFirst()];
            }
        }
        return Arrays.copyOf(ans, j);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ans = new Solution_239_滑动窗口最大值_hard().maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ans));
    }
}

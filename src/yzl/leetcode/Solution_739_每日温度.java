package yzl.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution_739_每日温度 {
    // 暴力法
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }

    // 单调栈：左边第一个或者右边第一个比当前大的元素，都可以构建从栈顶到栈底的单调递增栈。
    // 使用stack
    public int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] res = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    // 单调栈，使用deque，性能比Stack好很多。
    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        int i = 1;
        while (i < n) {
            if (!deque.isEmpty() && temperatures[i] > temperatures[deque.peekLast()]) {
                int cur = deque.removeLast();
                ans[cur] = i - cur;
            } else {
                deque.add(i);
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temps = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new Solution_739_每日温度().dailyTemperatures(temps);
        System.out.println(Arrays.toString(ans));
    }
}

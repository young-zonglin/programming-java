package yzl.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortByStack {
    public static void main(String[] args) {
        int[] arr = {11, 11, 6, 1, 3, 9, 6, 4, 9, 2};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /*
     * 本质上是一个BFS
     * 基于Stack栈
     * 使用栈来保存区间内的起始和结束指针
     */
    public static void sort(int[] arr, int low, int high) {
        Stack<Integer> stack = new Stack<>();
        if (low < high) {
            // stack的初始化
            stack.push(high);
            stack.push(low);
            while (!stack.isEmpty()) {
                int left = stack.pop();
                int right = stack.pop();
                // 每次通过partition函数来确定pivot的位置
                int idx = partition(arr, left, right);
                // 左区间
                if (left < idx - 1) {
                    stack.push(idx - 1);
                    stack.push(left);
                }
                // 右区间
                if (right > idx + 1) {
                    stack.push(right);
                    stack.push(idx + 1);
                }
            }
        }
    }

    // 与递归解法中的partition函数一模一样，每次只负责一个区间的一趟快排
    private static int partition(int[] arr, int left, int right) {
        int base = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= base) {
                right--;
            }
            // 此时left可用
            // 其实就是一次交换
            arr[left] = arr[right];
            while (left < right && arr[left] <= base) {
                left++;
            }
            // 此时right可用
            // 其实就是一次交换
            arr[right] = arr[left];
        }
        // 此时left可用
        arr[left] = base;
        // 因为是base，所以return left
        return left;
    }
}

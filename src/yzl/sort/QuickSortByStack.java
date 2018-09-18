package yzl.sort;

import java.util.Arrays;
import java.util.Stack;

public class QuickSortByStack {
    public static void main(String[] args) {
        int[] arr = {6,1,3,9,6,4};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int low, int high) {
        // 使用栈来保存区间内的起始和结束指针
        Stack<Integer> stack = new Stack<>();
        if (low < high) {
            stack.push(high);
            stack.push(low);
            while (!stack.isEmpty()) {
                int left = stack.pop();
                int right = stack.pop();
                // 每次通过partition函数来确定子区间的结束或起始位置
                int idx = partition(arr, left, right);
                // 左区间
                if (left < idx-1) {
                    stack.push(idx-1);
                    stack.push(left);
                }
                // 右区间
                if (right > idx+1) {
                    stack.push(right);
                    stack.push(idx+1);
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
            arr[left] = arr[right];
            while (left < right && arr[left] <= base) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = base;
        return left;
    }
}

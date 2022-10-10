package yzl.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] nums = {1, 8, 20, 3, 5, 41, 2, 1, 1, 5, 7, 20, 90, 50, 3};
        HeapSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int len = nums.length;
        // initial max heap.
        // 第一个非叶子节点，从右到左，从下到上
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjust(nums, i, len);
        }
        // heap sort
        for (int j = len - 1; j > 0; j--) {
            // 每次交换堆顶和末尾一个元素
            swap(nums, 0, j);
            // 末尾已经有序，只动了堆顶，故只调整堆顶
            adjust(nums, 0, j);
        }
    }

    /**
     * 对子树进行调整，使得以top为顶点的子树是大顶堆
     *
     * @param nums 完整体的树，树状数组
     * @param top  子树的root根顶点
     * @param len  用于截取子树
     */
    private static void adjust(int[] nums, int top, int len) {
        // 1. 先check根顶点的左孩子节点
        // 2. 如果右孩子节点更大，则check右子节点
        // 3. 如果孩子节点更大，则把孩子节点和父节点交换一下
        // 4. 继续check下一层，顺着交换过的分路
        for (int k = top * 2 + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && nums[k] < nums[k + 1]) {
                k = k + 1;
            }
            if (nums[top] < nums[k]) {
                swap(nums, top, k);
                top = k;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

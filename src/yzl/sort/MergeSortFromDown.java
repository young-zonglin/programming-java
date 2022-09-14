package yzl.sort;

import java.lang.Math;

/**
 * 归并排序，非递归
 */
public class MergeSortFromDown {
    private static double[] aux; // 辅助空间

    private static void merge(double[] arr, int low, int mid, int high) {
        MergeSortFromTop.merge(arr, low, mid, high, aux);
    }

    public static void sort(double[] arr) {
        int len = arr.length;
        aux = new double[len];
        // sz是步长，逐步变大，一一 => 两两 => 四四
        for (int sz = 1; sz < len; sz *= 2) {
            // 开始两两归并
            // mid < len-1 并且 mid=low + sz - 1 => low < len-sz
            for (int low = 0; low < len - sz; low += sz * 2) {
                merge(arr, low, low + sz - 1, Math.min(low + 2 * sz - 1, len - 1));
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        MergeSortFromDown.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}

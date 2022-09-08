package yzl.sort;

/**
 * 希尔排序，插入排序的改进版
 * 步长逐步变小，宏观排序=>微观排序
 * 增量序列
 * 升序排序
 * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)
 */
public class ShellSort {
    public static void sort(double[] array) {
        int len = array.length;
        double now;
        // gap/2是希尔增量
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                now = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > now) {
                    // 插入排序的移动
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = now;
            }
            gap /= 2;
        }
    }

    public static void main(String[] args) {
        double[] a = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8, -5.8};
        ShellSort.sort(a);
        for (double tmp : a) {
            System.out.print(tmp + " ");
        }
    }
}

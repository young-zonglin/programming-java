package yzl.sort;

/**
 * 插入排序
 * 一个有序序列，将待排序元素，插入合适位置，涉及数组移动
 * 升序排序
 */
public class InsertionSort {
    public static void sort(double[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            double now = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > now; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = now;
        }
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        InsertionSort.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp + " ");
        }
    }
}

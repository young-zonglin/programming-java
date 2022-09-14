package yzl.sort;

import yzl.utils.Tools;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /*
     * 一趟排序，小 < pivot < 大
     * 递归，分治
     */
    private static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        if (low >= high) return;
        // j是pivot的index
        int j = partition(arr, low, high);
        // 递归，分治
        sort(arr, low, j - 1);
        sort(arr, j + 1, high);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /*
     * 双指针
     * 快排是一种交换排序
     * 一定是low < high
     */
    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        // pivot/基准，一般取子串的首个或末尾元素
        T pivot = arr[low];
        int i = low; // 底下++i，i一定指向下一个元素
        int j = high + 1; // 底下--j，所以j先+1，才不会遗漏子串的最后一个元素
        while (true) {
            // Avoid array out of bounds.
            // 从左扫描，找到>pivot的数
            while (i < high && arr[++i].compareTo(pivot) <= 0) ;
            // 从右扫描，找到<pivot的数
            while (j > low && pivot.compareTo(arr[--j]) <= 0) ;
            if (i >= j) break;
            swap(arr, i, j);
        }
        // 把基准值放到合适的位置，此时 小 < pivot < 大
        // 一定是交换low和j，因为low是pivot，j是<=pivot的数
        swap(arr, low, j);
        return j;
    }

    public static void main(String[] args) {
        double[] arr = {10.2, 5.2, 3, 4, 10.1, 7, 1, 3, 5, 7.3, -1, -5, 0, 10, 5.8};
        Double[] newArr = Tools.toDoubleArr(arr);

        QuickSort.sort(newArr);
        for (double tmp : newArr) {
            System.out.print(tmp + " ");
        }
    }
}

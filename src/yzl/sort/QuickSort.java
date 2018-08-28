package yzl.sort;

import yzl.utils.Tools;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private static <T extends Comparable<T>> void sort(T[] arr, int low, int high) {
        if (low >= high) return;
        int j = partition(arr, low, high);
        sort(arr, low, j-1);
        sort(arr, j+1, high);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[low];
        int i = low;
        int j = high+1;
        while (true) {
            // Avoid array out of bounds.
            while (i < high && arr[++i].compareTo(pivot) < 0);
            while (j > low && pivot.compareTo(arr[--j]) < 0);
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10.1, 7, 1, 3, 5, 7.3, -1, -5, 0, 10, 5.8};
        Double[] newArr = Tools.toDoubleArr(arr);

        QuickSort.sort(newArr);
        for (double tmp : newArr) {
            System.out.print(tmp+" ");
        }
    }
}

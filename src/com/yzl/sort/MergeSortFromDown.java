package com.yzl.sort;
import java.lang.Math;

public class MergeSortFromDown {
    private static double[] aux;

    private static void merge(double[] arr, int low, int mid, int high) {
        System.arraycopy(arr, low, aux, low, high-low+1);
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i > mid) arr[k] = aux[j++];
            else if (j > high) arr[k] = aux[i++];
            else if (aux[i] < aux[j]) arr[k] = aux[i++];
            else arr[k] = aux[j++];
        }
    }

    public static double[] sort(double[] arr) {
        int len = arr.length;
        aux = new double[len];
        for (int sz = 1; sz<len; sz *= 2)
            for (int low = 0; low < len-sz; low += sz*2)
                // mid < len-1 => low < len-sz
                merge(arr, low, low+sz-1, Math.min(low+2*sz-1, len-1));
        return arr;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8};
        arr = MergeSortFromDown.sort(arr);
        for (double tmp : arr) {
            System.out.print(tmp+" ");
        }
    }
}

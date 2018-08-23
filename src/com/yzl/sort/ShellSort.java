package com.yzl.sort;

public class ShellSort {
    public static double[] sort(double[] arr) {
        int len = arr.length;
        int h = 1;
        while (h < len/3) h = 3*h+1;
        while (h >= 1) {
            for (int i = h; i < len; i++)
                for (int j=i; j>=h && arr[j]<arr[j-h]; j-=h) {
                    double tmp = arr[j];
                    arr[j] = arr[j-h];
                    arr[j-h] = tmp;
                }
            h /= 3;
        }
        return arr;
    }

    public static void main(String[] args) {
        double[] a = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8, -5.8};
        a = ShellSort.sort(a);
        for (double tmp : a) {
            System.out.print(tmp+" ");
        }
    }
}

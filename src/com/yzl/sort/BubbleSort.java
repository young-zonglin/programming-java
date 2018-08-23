package com.yzl.sort;

public class BubbleSort {
    public static double[] sort(double[] a) {
        int n = a.length;
        for (int i=1; i<n; i++)
            for (int j=0; j<n-i; j++) {
                if (a[j] > a[j + 1]) {
                    double tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        return a;
    }

    public static void main(String[] args) {
        double[] a = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7};
        a = BubbleSort.sort(a);
        for (double tmp : a) {
            System.out.print(tmp+" ");
        }
    }
}

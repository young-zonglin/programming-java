package yzl.topk;

import yzl.median.QuickSelect;

public class TopKQuickSelect {
    public static double[] topK(double[] arr, int topK) {
        QuickSelect.select(arr, topK-1);
        double[] ret = new double[topK];
        for (int i=0; i<topK; i++)
            ret[i] = arr[i];
        return ret;
    }

    public static void main(String[] args) {
        double[] arr = {1, 5.2, 3, 4, 10, 7, 1, 3, 5, 7, -1, -5, 0, 10, 5.8, 20};
        double[] topK = TopKQuickSelect.topK(arr, 10);
        for (double tmp : topK) {
            System.out.print(tmp+" ");
        }
    }
}

package yzl.utils;

public class Tools {
    public static Double[] toDoubleArr(double[] arr) {
        int len = arr.length;
        Double[] ret = new Double[len];
        for (int i = 0; i<len; i++)
            ret[i] = arr[i];
        return ret;
    }

    public static Double[] toDoubleArr(int[] arr) {
        int len = arr.length;
        Double[] ret = new Double[len];
        for (int i = 0; i<len; i++)
            ret[i] = new Double(arr[i]);
        return ret;
    }
}

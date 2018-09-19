package yzl.backpack;

import java.util.Scanner;

public class Exhaustion {
    public double resultWeight;
    public double maxValue;
    public int[] selection;

    public void exhaustion(int goodsNum, double capacity, double[] weights, double[] values) {
        resultWeight = 0;
        maxValue = 0;
        selection = new int[goodsNum];

        for (int i=0; i<Math.pow(2, goodsNum); i++) {
            int[] currSelect = convert(i, goodsNum);
            int currW = 0;
            int currV = 0;
            for (int j=0; j<goodsNum; j++) {
                currW += currSelect[j] * weights[j];
                currV += currSelect[j] * values[j];
            }
            if (currW <= capacity && currV > maxValue) {
                resultWeight = currW;
                maxValue = currV;
                System.arraycopy(currSelect, 0, selection, 0, goodsNum);
            }
        }
    }

    /**
     * Convert decimal number to binary mode.
     */
    private int[] convert(int decimalNum, int retArrayLen) {
        int[] retBinary = new int[retArrayLen];
        int i = 0;
        while (true) {
            retBinary[i++] = decimalNum%2;
            decimalNum /= 2;
            if (decimalNum == 0) break;
        }
        return retBinary;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int goodsNum = reader.nextInt();
        int capacity = reader.nextInt();
        double[] weights = new double[goodsNum];
        double[] values = new double[goodsNum];
        int i = 0;
        int j = 0;
        while (reader.hasNext()) {
            weights[i++] = reader.nextDouble();
            values[j++] = reader.nextDouble();
        }

        Exhaustion backpackExh = new Exhaustion();
        backpackExh.exhaustion(goodsNum, capacity, weights, values);

        System.out.println(backpackExh.resultWeight + " " + backpackExh.maxValue);
        for (i = 0; i < goodsNum; i++) {
            if (backpackExh.selection[i] == 1)
                // Print the ID of the selected goods.
                System.out.print((i + 1) + " ");
        }
        System.out.println();
    }
}

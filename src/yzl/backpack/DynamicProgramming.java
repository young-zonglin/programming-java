package yzl.backpack;

import java.util.Scanner;

public class DynamicProgramming {
    public int dynamicProgramming(int goodsNum, int capacity,
                                     int weights[], int[] values) {
        int[][] maxValues = new int[goodsNum+1][capacity+1];
        int i, j;
        for (i=0; i<=goodsNum; i++) {
            maxValues[i][0] = 0;
        }
        for (i=0; i<=capacity; i++) {
            maxValues[0][i] = 0;
        }
        for (i=1; i<=goodsNum; i++)
            for (j=1; j<=capacity; j++) {
                if (weights[i-1] > j)
                    maxValues[i][j] = maxValues[i-1][j];
                else {
                    int inValue = maxValues[i-1][j-weights[i-1]] + values[i-1];
                    int outValue = maxValues[i-1][j];
                    maxValues[i][j] = Math.max(inValue, outValue);
                }
            }
        return maxValues[goodsNum][capacity];
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int goodsNum = reader.nextInt();
        int capacity = reader.nextInt();
        int[] weights = new int[goodsNum];
        int[] values = new int[goodsNum];
        int i = 0;
        int j = 0;
        boolean readWeight = true;

        while (reader.hasNext()) {
            if (readWeight) {
                weights[i++] = reader.nextInt();
                readWeight = false;
            } else {
                values[j++] = reader.nextInt();
                readWeight = true;
            }
        }

        DynamicProgramming dp = new DynamicProgramming();
        int maxValue = dp.dynamicProgramming(goodsNum, capacity, weights, values);
        System.out.println("max value: "+maxValue);
    }
}

package yzl.backpack;

import java.util.Scanner;

public class DynamicProgramming {
    public int dynamicProgramming(int goodsNum, int capacity,
                                  int weights[], int[] values) {
        int[][] maxValues = new int[goodsNum+1][capacity+1];
        for (int i=1; i<=goodsNum; i++)
            for (int j=1; j<=capacity; j++) {
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
        while (reader.hasNext()) {
            weights[i++] = reader.nextInt();
            values[j++] = reader.nextInt();
        }

        DynamicProgramming dp = new DynamicProgramming();
        int maxValue = dp.dynamicProgramming(goodsNum, capacity, weights, values);
        System.out.println("max value: "+maxValue);
    }
}

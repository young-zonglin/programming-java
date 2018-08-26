package yzl.backpack;

import java.util.Scanner;

public class BackTracking {
    public double resultWeight;
    public double maxValue;
    public int[] selection;

    private double currW;
    private double currV;
    private int[] currChoice;

    public void getBestRes(int goodsNum, double capacity,
                           double[] weights, double[] values) {
        resultWeight = 0;
        maxValue = 0;
        selection = new int[goodsNum];

        currW = 0;
        currV = 0;
        currChoice = new int[goodsNum];

        backtrack(0, goodsNum, capacity, weights, values);
    }

    private void backtrack(int layer, int goodsNum, double capacity,
                           double[] weights, double[] values) {
        if (layer >= goodsNum) {
            if (currW < capacity && currV > maxValue) {
                resultWeight = currW;
                maxValue = currV;
                System.arraycopy(currChoice, 0, selection, 0, goodsNum);
            }
        } else {
            for (int i=0; i<=1; i++) {
                currChoice[layer] = i;
                if (currW+weights[layer]*i <= capacity) {
                    currW += weights[layer]*i;
                    currV += values[layer]*i;
                    backtrack(layer+1, goodsNum, capacity, weights, values);
                    currW -= weights[layer]*i;
                    currV -= values[layer]*i;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int goodsNum = reader.nextInt();
        int capacity = reader.nextInt();
        double[] weights = new double[goodsNum];
        double[] values = new double[goodsNum];
        int i = 0;
        int j = 0;
        boolean readWeight = true;

        while (reader.hasNext()) {
            if (readWeight) {
                weights[i++] = reader.nextDouble();
                readWeight = false;
            } else {
                values[j++] = reader.nextDouble();
                readWeight = true;
            }
        }

        BackTracking bt = new BackTracking();
        bt.getBestRes(goodsNum, capacity, weights, values);

        System.out.println(bt.resultWeight + " " + bt.maxValue);
        for (i = 0; i < goodsNum; i++) {
            if (bt.selection[i] == 1)
                System.out.print((i + 1) + " ");
        }
        System.out.println();
    }
}

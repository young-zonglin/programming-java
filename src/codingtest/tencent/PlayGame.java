package codingtest.tencent;

import java.util.Scanner;

public class PlayGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int compNums = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int minTimes = new PlayGame().exhaustion(compNums, x, y);
        System.out.print(minTimes);
    }

    public int exhaustion(int compNums, int x_score, int y_score) {
        int minTimes = Integer.MAX_VALUE;
        int scores[] = new int[compNums];
        for (int i = 0; i<compNums; i++) {
            scores[i] = i+1;
        }

        for (int i=0; i<Math.pow(2, compNums); i++) {
            int[] curSel = convert(i, compNums);
            int xCurScore = 0, yCurScore = 0;
            int count = 0;
            for (int j=0; j<compNums; j++) {
                if (curSel[j] == 1) {
                    xCurScore += scores[j];
                    count++;
                } else {
                    yCurScore += scores[j];
                }
            }
            if (xCurScore == x_score && yCurScore == y_score && count < minTimes) {
                minTimes = count;
            }
        }
        return minTimes == Integer.MAX_VALUE ? -1 : minTimes;
    }

    /**
     * Convert decimal number to binary mode.
     */
    private int[] convert(int decimalNum, int retArrLen) {
        int[] retBinary = new int[retArrLen];
        int i = 0;
        while (true) {
            retBinary[i++] = decimalNum%2;
            decimalNum /= 2;
            if (decimalNum == 0) break;
        }
        return retBinary;
    }
}

package dp;

import java.util.Scanner;

public class ToyBlocksBuilding {
    public int sumOfBuildMethod(int blocksNum) {
        if (blocksNum < 3) {
            System.out.println("积木的数量应该要>=3");
            return 0;
        }

        int[][] sumOfMethod = new int[blocksNum+1][blocksNum+1];
        int i, j, t;

        for (i=1; i<=blocksNum; i++)
            for (j=1; j<blocksNum; j++) {
                if (j > i)
                    sumOfMethod[i][j] = 0;
                else if (j == i)
                    sumOfMethod[i][j] = 1;
                else {
                    int tmp = 0;
                    for (t=1; t<j; t++)
                        tmp += sumOfMethod[i-j][t];
                    sumOfMethod[i][j] = tmp;
                }
            }

        for (i=0; i<=blocksNum; i++) {
            for (j=0; j<=blocksNum; j++) {
                System.out.print(sumOfMethod[i][j]+" ");
            }
            System.out.println();
        }

        int res = 0;
        for (i=2; i<=blocksNum-1; i++)
            res += sumOfMethod[blocksNum][i];
        return res;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        reader.close();
        int result = new ToyBlocksBuilding().sumOfBuildMethod(N);
        System.out.println(result);
    }
}

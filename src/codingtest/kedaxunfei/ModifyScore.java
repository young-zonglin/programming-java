package codingtest.kedaxunfei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * AC
 */
public class ModifyScore {
    public int needModifyTimes(int[] scores, int k) {
        int i;
        if (average(scores) >= k) return 0;
        else {
            Arrays.sort(scores);
            for (i = 0; i<scores.length; i++) {
                scores[i] = 100;
                if (average(scores) >= k)
                    break;
            }
        }
        return i+1;
    }

    private double average(int[] nums) {
        return Arrays.stream(nums).sum() / nums.length;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int T = reader.nextInt();
        for (int i = 1; i<=T; i++) {
            int n = reader.nextInt();
            int X = reader.nextInt();
            int[] scores = new int[n];
            for (int j=0; j<n; j++) {
                scores[j] = reader.nextInt();
            }
            System.out.println(new ModifyScore().needModifyTimes(scores, X));
        }
    }
}

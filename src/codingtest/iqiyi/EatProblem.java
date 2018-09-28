package codingtest.iqiyi;

import yzl.fibonacci.DP;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class EatProblem {
    /**
     * DP solution
     * @param n, n foods.
     * @return BigInteger, if int or long, it will overflow.
     */
    public BigInteger getRes_1(int n) {
        BigInteger[] state = new BigInteger[n];
        state[n-1] = BigInteger.ONE;
        for (int i = n-2; i>=0; i--) {
            BigInteger count = BigInteger.ONE;
            for (int j = i+2; j<n; j++) {
                count = count.add(state[j]);
            }
            state[i] = count;
        }
        return sum(state);
    }

    // Fibonacci solution.
    public BigInteger getRes_2(int n) {
        DP fibonacci = new DP();
        BigInteger[] fibs = new BigInteger[n];
        HashMap<Integer, BigInteger> memory = new HashMap<>();
        for (int i = 0; i<n; i++) {
            fibs[i] = fibonacci.fastFib(i, memory);
        }
        return sum(fibs);
    }

    private BigInteger sum(BigInteger[] nums) {
        BigInteger ret = BigInteger.ZERO;
        for (BigInteger tmp : nums) {
            ret = ret.add(tmp);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger res = new EatProblem().getRes_2(n).add(BigInteger.ONE);
        System.out.print(res);
    }
}

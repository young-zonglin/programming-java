package yzl.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DP {
    public BigInteger fastFib(int n, Map<Integer, BigInteger> dp) {
        if (n == 0 || n == 1) return BigInteger.ONE;
        if (!dp.containsKey(n)) {
            dp.put(n, fastFib(n - 1, dp).add(fastFib(n - 2, dp)));
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        int n = 150;
        Map<Integer, BigInteger> memory = new HashMap<>();
        Long start = System.currentTimeMillis();
        BigInteger res = new DP().fastFib(n, memory);
        System.out.println(res);
        Long end = System.currentTimeMillis();
        System.out.println("Time consuming: " + (end - start) / 1000.0);
    }
}

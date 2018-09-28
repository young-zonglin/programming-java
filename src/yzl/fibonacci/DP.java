package yzl.fibonacci;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DP {
    public BigInteger fastFib(int n, Map<Integer, BigInteger> memory) {
        if (n==0 || n==1) return BigInteger.ONE;
        BigInteger v = memory.get(n);
        if (v == null) {
            BigInteger middle = fastFib(n-1, memory).add(fastFib(n-2, memory));
            memory.put(n, middle);
            return middle;
        } else {
            return v;
        }
    }

    public static void main(String[] args) {
        int n = 150;
        Map<Integer, BigInteger> memory = new HashMap<>();
        Long start = System.currentTimeMillis();
        BigInteger res = new DP().fastFib(n, memory);
        System.out.println(res);
        Long end = System.currentTimeMillis();
        System.out.println("Time consuming: "+(end-start)/1000.0);
    }
}

package yz.fibonacci;

import java.util.HashMap;
import java.util.Map;

public class DP {
    public int fastFib(int n, Map<Integer, Integer> memory) {
        if (n==0 || n==1) return 1;
        Integer v = memory.get(n);
        if (v == null) {
            int middle =  fastFib(n-1, memory) + fastFib(n-2, memory);
            memory.put(n, middle);
            return middle;
        } else {
            return v;
        }
    }

    public static void main(String[] args) {
        int n = 150;
        Map<Integer, Integer> memory = new HashMap<>();
        Long start = System.currentTimeMillis();
        int res = new DP().fastFib(n, memory);
        System.out.println(res);
        Long end = System.currentTimeMillis();
        System.out.println("Time consuming: "+(end-start)/1000.0);
    }
}

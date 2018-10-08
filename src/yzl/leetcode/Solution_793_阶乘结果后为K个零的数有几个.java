package yzl.leetcode;

import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

public class Solution_793_阶乘结果后为K个零的数有几个 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int res = new Solution_binarySearch().preimageSizeFZF(k);
        System.out.println(res);
//        Map<Integer, BigInteger> memory = new HashMap<>();
//        for (int i = 0; i<100; i++) {
//            System.out.println(i + ":" + FactorialUtils.getFactorial(i, memory));
//        }
    }
}

class Solution_binarySearch {
    public int preimageSizeFZF(long K) {
        long low = 0;
        long high = 5*(K+1);
        while (low <= high) {
            long middle = low + (high-low)/2;
            long zeroNum = FactorialUtils.tailingZeroNum(middle);
            if (zeroNum == K) return 5;
            else if (zeroNum < K) low = middle+1;
            else high = middle-1;
        }
        return 0;
    }
}

class Solution_timeout {
    public int preimageSizeFZF(int K) {
        int down = 0;
        int step = 1;
        boolean downChange = false;
        while (FactorialUtils.tailingZeroNum(down) < K) {
            down += step;
            step *= 10;
            downChange = true;
        }
        if (downChange) {
            down -= step;
            step /= 10;
        }
        int top = down;
        while (FactorialUtils.tailingZeroNum(top) <= K) {
            top += step;
            step *= 10;
        }
        // binary search
        while (down <= top) {
            int middle = down + (top-down)/2;
            long zeroNum = FactorialUtils.tailingZeroNum(middle);
            if (zeroNum == K) return 5;
            else if (zeroNum < K) down = middle+1;
            else top = middle-1;
        }
        return 0;
    }
}

class FactorialUtils {
    public static long tailingZeroNum(long k) {
        if (k < 0) return -1;
        else if (k < 5) return 0;
        long count = 0;
        long tmp = k/5;
        while (tmp != 0) {
            count += tmp;
            tmp /= 5;
        }
        return count;
    }

    public static BigInteger getFactorial(int n, Map<Integer, BigInteger> memory) {
        if (n <= 1) return BigInteger.ONE;
        BigInteger val = memory.get(n);
        if (val == null) {
            val = getFactorial(n-1, memory).multiply(BigInteger.valueOf(n));
            memory.put(n, val);
        }
        return val;
    }
}

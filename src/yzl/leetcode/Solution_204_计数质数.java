package yzl.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_204_计数质数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long startTime = System.currentTimeMillis();
        int res = new Solution_204_计数质数().countPrimes_SieveOfEratosthenes(n);
        long endTime = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("Duration time: " + (endTime-startTime) + "ms");
    }

    public int countPrimes_SieveOfEratosthenes(int n) {
        if (n <= 2) return 0;
        // Default value is false.
        // Index is identical to value.
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= (int)Math.sqrt(n-1); i++) {
            if (isPrime[i]) {
                for (int j = i*i; j<n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i<n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    // It will time out.
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 1; // 2 is a prime
        for (int i = 3; i<n; i+=2) {
            if (Prime.isPrimeRegular(i)) {
                count++;
            }
        }
        return count;
    }
}

// The following methods will time out.
class Prime {
    public static boolean isPrimeExhaustion(int num) {
        for (int i = 2; i<num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeExhaustionImproved(int num) {
        for (int i = 2; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeRegular(int num) {
        if (num == 2 || num == 3) return true;
        if (num % 6 != 1 && num % 6 != 5) return false;
        for (int i = 5; i <= (int)Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

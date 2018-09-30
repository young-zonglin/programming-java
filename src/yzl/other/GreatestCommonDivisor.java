package yzl.other;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public int getGCD(int a, int b) {
        if (a == b) return a;
        else if (a > b) return getGCD(a-b, b);
        else return getGCD(a, b-a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int res = new GreatestCommonDivisor().getGCD(a, b);
        System.out.print(res);
    }
}

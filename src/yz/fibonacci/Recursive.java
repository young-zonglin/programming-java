package yz.fibonacci;

public class Recursive {
    public int fibonacci(int n) {
        if (n==1 || n==0) return 1;
        else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        int n = 44;
        Long start = System.currentTimeMillis();
        int res = new Recursive().fibonacci(n);
        System.out.println(res);
        Long end = System.currentTimeMillis();
        System.out.println("Time consuming: "+(end-start)/1000.0);
    }
}

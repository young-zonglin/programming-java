package codingtest.netease;

import java.util.Scanner;

/**
 * This may be correct.
 */
public class Champagne {
    private int volume[];
    private int howMuch[];

    public Champagne(int volume[]) {
        int len = volume.length;
        this.volume = new int[len];
        this.howMuch = new int[len];
        System.arraycopy(volume, 0, this.volume, 0, len);
    }

    public int getLayerHowMuch(int k) {
        return this.howMuch[k-1];
    }

    public void putChampagne(int x, int v) {
        if (x > volume.length) return;
        int idx = x-1;
        if (howMuch[idx]+v > volume[idx]) {
            int duo = v - (volume[idx]-howMuch[idx]);
            howMuch[idx] = volume[idx];
            putChampagne(x+1, duo);
        } else {
            howMuch[idx] += v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] volume = new int[n];
        for (int i = 0; i<n; i++) {
            volume[i] = sc.nextInt();
        }
        Champagne champagne = new Champagne(volume);
        for (int i = 0; i<m; i++) {
            int judge = sc.nextInt();
            if (judge == 1) {
                int x = sc.nextInt();
                int v = sc.nextInt();
                champagne.putChampagne(x, v);
            } else if (judge == 2) {
                int k = sc.nextInt();
                System.out.println(champagne.getLayerHowMuch(k));
            }
        }
    }
}

package yzl.kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 36% AC...
 */
public class Killer {
    public int getNights(Integer[] killers) {
        List<Integer> lives = new ArrayList<>();
        boolean keep = true;
        int nightsCount = 0;
        while (keep) {
            int count = 0;
            lives.clear();
            boolean anyBodyDie = false;
            for (int i = 0; i<killers.length-1; i++) {
                if (killers[i] > killers[i+1]) {
                    count++;
                    anyBodyDie = true;
                } else {
                    lives.add(killers[i-count]);
                    count = 0;
                }
            }
            if (!anyBodyDie) {
                keep = false;
            } else {
                nightsCount++;
                killers = new Integer[lives.size()];
                lives.toArray(killers);
            }
        }

        return nightsCount;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Integer[] killers = new Integer[n];
        for (int i = 0; i<n; i++) {
            killers[i] = reader.nextInt();
        }
        System.out.println(new Killer().getNights(killers));
    }
}

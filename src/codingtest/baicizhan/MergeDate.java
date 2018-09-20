package codingtest.baicizhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergeDate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] dates = new int[n];
        for (int i = 0; i<n; i++) {
            dates[i] = in.nextInt();
        }
        List<List<Integer>> res = new MergeDate().process(dates);
        for (List<Integer> tmp : res) {
            if (tmp.size() >= 3) {
                System.out.print(tmp.get(0)+"-"+tmp.get(tmp.size()-1)+" ");
            } else {
                for (Integer date : tmp) {
                    System.out.print(date + " ");
                }
            }
        }
    }

    public List<List<Integer>> process(int[] dates) {
        List<List<Integer>> list = new ArrayList<>();
        int len = dates.length;
        if (len <= 0) return list;
        List<Integer> cur = new ArrayList<>();
        for (int i = 1; i<len; i++) {
            if (dates[i] == dates[i-1]+1) {
                cur.add(dates[i-1]);
            } else {
                cur.add(dates[i-1]);
                list.add(cur);
                cur = new ArrayList<>();
            }
            if (i == len-1) cur.add(dates[i]);
        }
        if (!cur.isEmpty()) {
            list.add(cur);
        }
        return list;
    }
}

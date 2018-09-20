package codingtest.baicizhan;

import java.util.Scanner;

public class Degree {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String start = in.nextLine();
//        String end = in.nextLine();
        String start = "14:52:11";
        String end = "21:41:14";
        int[] res = new Degree().getRes(start, end);
        for (Integer tmp : res) {
            System.out.println(tmp);
        }
    }

    public int[] getRes(String start, String end) {
        int duration = getSecond(end) - getSecond(start);
        int second_degree = (duration / 60) * 360 + (duration % 60) * 6;
        int min_degree = (int)((second_degree / 360) * 6 + ((second_degree % 360) / 360.0) * 6);
        int hour_degree = (int)((min_degree / 360) * 30 + ((min_degree % 360) / 360.0) * 30);
        return new int[]{hour_degree, min_degree, second_degree};
    }

    private int getSecond(String time) {
        String[] strs = time.split(":");
        int len = strs.length;
        int second = 0;
        for (int i = 0; i<len; i++) {
            second += Integer.parseInt(strs[i]) * Math.pow(60, len-i-1);
        }
        return second;
    }
}

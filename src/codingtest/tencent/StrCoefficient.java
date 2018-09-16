package codingtest.tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrCoefficient {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = Integer.parseInt(in.nextLine());
        String a = in.nextLine();
        String b = in.nextLine();
        int strCoefficient = new StrCoefficient().another(a, b, k);
        System.out.print(strCoefficient);
    }

    // It will time out.
    public int getCoefficient(String a, String b, int k) {
        Set<String> set = new HashSet<>();
        int a_len = a.length();
        for (int i = 0; i<=a_len-k; i++) {
             set.add(a.substring(i, i+k));
        }
        int count = 0;
        int b_len = b.length();
        for (String tmp : set) {
            for (int i = 0; i<=b_len-k; i++) {
                if (tmp.equals(b.substring(i, i+k))) {
                    count++;
                }
            }
        }
        return count;
    }

    // Error...why...
    public int another(String a, String b, int k) {
        Set<String> set = new HashSet<>();
        int a_len = a.length();
        for (int i = 0; i<=a_len-k; i++) {
            set.add(a.substring(i, i+k));
        }
        int count = 0;
        for (String tmp : set) {
            Pattern pt = Pattern.compile(tmp);
            Matcher mt = pt.matcher(b);
            while (mt.find()) {
                System.out.println(mt.group());
                count++;
            }
        }
        return count;
    }
}

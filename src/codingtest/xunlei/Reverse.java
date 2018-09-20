package codingtest.xunlei;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reverse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String origin = in.nextLine();
        String res = new Reverse().reverse(origin);
        System.out.print(res);
    }

    public String reverse(String origin) {
        Pattern pt = Pattern.compile("[,.!?:@#]+$");
        String[] strs = origin.split("\\s+");
        int len = strs.length;
        int i = 0;
        for (; i<len; i++) {
            strs[i] = reversePunc(strs[i], pt);
        }
        int j = len-1;
        i = 0;
        while (i < j) {
            swap(strs, i++, j--);
        }
        StringBuilder builder = new StringBuilder();
        for (String tmp : strs) {
            tmp += " ";
            builder.append(tmp);
        }
        return builder.toString();
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    private String reversePunc(String origin, Pattern pt) {
        Matcher mt = pt.matcher(origin);
        String punc = "";
        if (mt.find()) {
            punc = mt.group();
        }
        return punc+origin.replace(punc, "");
    }
}

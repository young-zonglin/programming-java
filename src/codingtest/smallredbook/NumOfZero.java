package codingtest.smallredbook;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumOfZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int zerosNum = new NumOfZero().getZeroNum(n);
        System.out.print(zerosNum);
    }

    public int getZeroNum(int n) {
        BigInteger val = op(n);
        String str = val.toString();
        Pattern pattern = Pattern.compile("(0+)$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group().length();
        }
        return 0;

//        char[] chars = str.toCharArray();
//        int count = 0;
//        for (int i = chars.length-1; i>=0; i--) {
//            if (chars[i] == '0') {
//                count++;
//            } else {
//                break;
//            }
//        }
//        return count;
    }

    private BigInteger op(int n) {
        Map<Integer, BigInteger> memory = new HashMap<>();
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i<=n; i++) {
            res = res.multiply(getFactorial(i, memory));
        }
        return res;
    }

    private BigInteger getFactorial(int n, Map<Integer, BigInteger> memory) {
        if (n == 1) return BigInteger.ONE;
        BigInteger val = memory.get(n);
        if (val == null) {
            val = getFactorial(n-1, memory).multiply(BigInteger.valueOf(n));
            memory.put(n, val);
            return val;
        } else {
            return val;
        }
    }
}

package yzl.jd;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * It will time out.
 */
public class SimilarStr {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solve(String S, String T) {
        int s_len = S.length();
        int t_len = T.length();
        if (s_len < t_len) return 0;
        int count = 0;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i<=s_len-t_len; i++) {
            map.clear();
            count++;
            for (int j = i; j<i+t_len; j++) {
                Character s = S.charAt(j);
                Character t = T.charAt(j-i);
                if (map.containsKey(t) && map.get(t) != s) {
                    count--;
                    break;
                } else if (!map.containsKey(t)) {
                    map.put(t, s);
                }
            }
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _S;
        try {
            _S = in.nextLine();
        } catch (Exception e) {
            _S = null;
        }

        String _T;
        try {
            _T = in.nextLine();
        } catch (Exception e) {
            _T = null;
        }

        res = solve(_S, _T);
        System.out.println(String.valueOf(res));

    }
}

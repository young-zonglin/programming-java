package yzl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_118_杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                result.add(Collections.singletonList(1));
            } else if (i == 2) {
                result.add(Arrays.asList(1, 1));
            } else {
                List<Integer> lastRes = result.get(i - 2);
                List<Integer> thisRes = new ArrayList<>();
                thisRes.add(1);
                for (int j = 1; j < lastRes.size(); j++) {
                    thisRes.add(lastRes.get(j - 1) + lastRes.get(j));
                }
                thisRes.add(1);
                result.add(thisRes);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_118_杨辉三角().generate(5));
    }
}

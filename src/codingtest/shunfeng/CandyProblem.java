package codingtest.shunfeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CandyProblem {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int candy(double[] numbers) {
        int len = numbers.length;
        int[] assign = new int[len];
        for (int i = 0; i<len; i++) {
            assign[i] = 1;
        }
        Integer[] idxs = selectSort(numbers);
        for (int idx : idxs) {
            if (idx-1>=0 && numbers[idx-1]>numbers[idx] && assign[idx-1]<=assign[idx]) {
                assign[idx-1] = assign[idx]+1;
            }
            if (idx+1<len && numbers[idx+1]>numbers[idx] && assign[idx+1]<=assign[idx]) {
                assign[idx+1] = assign[idx]+1;
            }
        }
        return Arrays.stream(assign).sum();
    }

    private static Integer[] selectSort(double[] nums) {
        int len = nums.length;
        List<Integer> idxs = new ArrayList<>();

        int i, j;
        for (i = 0; i<len; i++) {
            double min = Double.MAX_VALUE;
            int minIndex = i;
            for (j = 0; j < len; j++) {
                if (idxs.contains(j)) continue;
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            idxs.add(minIndex);
        }
        Integer[] ret = new Integer[len];
        idxs.toArray(ret);
        return ret;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _numbers_size = Integer.parseInt(in.nextLine().trim());
        double[] _numbers = new double[_numbers_size];
        double _numbers_item;
        for(int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
            _numbers_item = Double.parseDouble(in.nextLine().trim());
            _numbers[_numbers_i] = _numbers_item;
        }

        res = candy(_numbers);
        System.out.println(String.valueOf(res));
    }
}

package yzl.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Solution_20_有效的括号 {
    public boolean isValid(String s) {
        List<Character> left = Arrays.asList('(', '{', '[');
        Map<Character, Integer> char2match = new HashMap<Character, Integer>() {{
            put('(', 1);
            put(')', 1);
            put('{', 2);
            put('}', 2);
            put('[', 3);
            put(']', 3);
        }};
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (left.contains(c)) {
                stack.push(c);
            } else if (!stack.empty() && Objects.equals(char2match.get(stack.peek()), char2match.get(c))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution_20_有效的括号().isValid("]"));
        System.out.println(new Solution_20_有效的括号().isValid("(]"));
        System.out.println(new Solution_20_有效的括号().isValid("["));
        System.out.println(new Solution_20_有效的括号().isValid("[]"));
    }
}

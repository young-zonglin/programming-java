package yzl.other;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 字节跳动，扑克牌问题
 * 手上一副牌，拿一张放桌上，再拿一张放牌底
 * 根据桌面的排序，推出手牌的排序
 * 用模拟法+逆序即可
 */
public class ByteDancePukeProblem {
    public static void main(String[] args) {
        Stack<String> desk = new Stack<>();
        //K/Q/J/10/9/8/7/6/5/4/3/2/1
        desk.add("K");
        desk.add("Q");
        desk.add("J");
        desk.add("10");
        desk.add("9");
        desk.add("8");
        desk.add("7");
        desk.add("6");
        desk.add("5");
        desk.add("4");
        desk.add("3");
        desk.add("2");
        desk.add("1");
        Deque<String> hand = new ArrayDeque<>();
        while (!desk.isEmpty()) {
            hand.addFirst(desk.pop());
            if (!desk.isEmpty()) {
                String tmp = hand.removeLast();
                hand.addFirst(tmp);
            }
        }
        System.out.println(hand);
    }
}

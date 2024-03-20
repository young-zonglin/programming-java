package yzl.leetcode;

public class Solution_155_最小栈 {
    Node head = null;

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            head = new Node(val, Math.min(val, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

package codingtest.smallredbook;

import java.util.Scanner;
import java.util.Stack;

class LinkedNode {
    public LinkedNode next;
    public int val;
    public LinkedNode(int x) { val = x; }

    public static LinkedNode createLinkedList(int[] arr) {
        LinkedNode head = null, oldHead;
        for (int i = arr.length - 1; i >= 0; i--) {
            oldHead = head;
            head = new LinkedNode(arr[i]);
            head.next = oldHead;
        }
        return head;
    }

    public static void showLinkedList(LinkedNode head) {
        LinkedNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}

public class ReverseLinkedList {
    private LinkedNode reverseBetween(LinkedNode head, int m, int n) {
        LinkedNode start = null, end = null, tail = null, cur = head, next;
        int count = 0;
        while (cur != null && count < n) {
            count++;
            if (m == 1) {
                end = head;
            } else if (count == m-1) {
                start = cur;
                end = start.next;
            }
            next = cur.next;
            if (count >= m) {
                LinkedNode oldLast = tail;
                tail = cur;
                tail.next = oldLast;
            }
            cur = next;
        }
        if (m == 1) head = tail;
        else if (start != null) start.next = tail;

        if (end != null) end.next = cur;
        return head;
    }

    public LinkedNode reverseK(LinkedNode head, int k, int n) {
        if (k > n) return head;
        int s = 1, e = k;
        while (e <= n) {
            head = reverseBetween(head, s, e);
            s += k;
            e += k;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (in.hasNextInt()) {
            stack.push(in.nextInt());
        }
        int k = stack.pop();
        int n = stack.size();
        int nums[] = new int[n];
        for (int i = n-1; i>=0; i--) {
            nums[i] = stack.pop();
        }
        LinkedNode head = LinkedNode.createLinkedList(nums);
        head = new ReverseLinkedList().reverseK(head, k, n);
        LinkedNode.showLinkedList(head);
    }
}

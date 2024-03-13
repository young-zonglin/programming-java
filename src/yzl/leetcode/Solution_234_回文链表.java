package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome linked list.
 */
public class Solution_234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        String raw = sb.toString();
        String reversed = sb.reverse().toString();
        return raw.equals(reversed);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(int[] arr) {
        ListNode head = null, oldHead;
        for (int i = arr.length - 1; i >= 0; i--) {
            oldHead = head;
            head = new ListNode(arr[i]);
            head.next = oldHead;
        }
        return head;
    }

    public static void showLinkedList(ListNode head, String description) {
        ListNode cur = head;
        System.out.println(description);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class Solution_234_one {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }
        int i = 0, j = values.size() - 1;
        while (i < j) {
            if (!values.get(i).equals(values.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution_234_two {
    public boolean isPalindrome(ListNode head) {
        ListNode tail = reverse(head);
        return isSame(head, tail);
    }

    private boolean isSame(ListNode head, ListNode tail) {
        if (head == null || tail == null) return true;
        while (head != tail) {
            if (head.val != tail.val) return false;
            if (head.next == tail) break;
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode tail = null, oldLast, cur = head;
        while (cur != null) {
            oldLast = tail;
            tail = new ListNode(cur.val);
            tail.next = oldLast;
            cur = cur.next;
        }
        return tail;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.showLinkedList(head, "forward");
        System.out.println(new Solution_234_two().isPalindrome(head));
    }
}

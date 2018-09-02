package yzl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome linked list.
 */
public class Solution_234 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 2};
        ListNode head = null, oldHead, cur;
        for (int i = arr.length - 1; i >= 0; i--) {
            cur = new ListNode(arr[i]);
            oldHead = head;
            head = cur;
            head.next = oldHead;
        }
        Solution_234_two.showLinkedList(head, "forward");
        System.out.println(new Solution_234_two().isPalindrome(head));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution_234_one {
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            values.add(cur.val);
            cur = cur.next;
        }
        int i = 0, j = values.size()-1;
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

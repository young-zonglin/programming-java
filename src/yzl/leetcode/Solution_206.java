package yzl.leetcode;

/**
 * Reverse linked list.
 */
public class Solution_206 {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 2};
        ListNode head = null, oldHead;
        for (int i = arr.length - 1; i >= 0; i--) {
            oldHead = head;
            head = new ListNode(arr[i]);
            head.next = oldHead;
        }
        Solution_234_two.showLinkedList(head, "forward");
        ListNode reverse = new Solution_206_two().reverseList(head);
        Solution_234_two.showLinkedList(reverse, "reverse");
    }
}

class Solution_206_one {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null, oldLast, cur = head;
        while (cur != null) {
            oldLast = tail;
            tail = new ListNode(cur.val);
            tail.next = oldLast;
            cur = cur.next;
        }
        return tail;
    }
}

class Solution_206_two {
    public ListNode reverseList(ListNode head) {
        ListNode tail = null, cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            ListNode oldLast = tail;
            tail = cur;
            tail.next = oldLast;
            cur = tmp;
        }
        return tail;
    }
}

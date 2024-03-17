package yzl.leetcode;

/**
 * Reverse linked list.
 */
public class Solution_206 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.showLinkedList(head, "forward");
        ListNode reverse = new Solution_206_two().reverseList(head);
        ListNode.showLinkedList(reverse, "reverse");
    }
}

class Solution_206_one {
    // 使用头插法解决反转链表
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
    // 不new一个节点的方法
    public ListNode reverseList(ListNode head) {
        ListNode tail = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            ListNode oldLast = tail;
            tail = cur;
            tail.next = oldLast;
            cur = next;
        }
        return tail;
    }
}

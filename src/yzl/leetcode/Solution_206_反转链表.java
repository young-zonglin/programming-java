package yzl.leetcode;

/**
 * Reverse linked list.
 */
public class Solution_206_反转链表 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.showLinkedList(head, "forward");
        ListNode reverse = new Solution_206_two().reverseList(head);
        ListNode.showLinkedList(reverse, "reverse");
    }
}

// 使用头插法解决反转链表
class Solution_206_one {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode oldHead = newHead;
            newHead = new ListNode(head.val);
            newHead.next = oldHead;
            head = head.next;
        }
        return newHead;
    }
}

// 不new一个节点的方法
class Solution_206_two {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null, oldHead, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            oldHead = newHead;
            newHead = cur;
            newHead.next = oldHead;
            cur = next;
        }
        return newHead;
    }
}

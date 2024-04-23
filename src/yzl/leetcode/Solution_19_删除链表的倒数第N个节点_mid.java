package yzl.leetcode;

// TODO：看评论区，递归 和 快慢指针
public class Solution_19_删除链表的倒数第N个节点_mid {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        if (len == n) return head.next;
        int cnt = 0;
        cur = head;
        while (cnt < len - n - 1) {
            cnt++;
            cur = cur.next;
        }
        if (n == 1) {
            cur.next = null;
        } else {
            cur.next = cur.next.next;
        }
        return head;
    }
}

package yzl.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 */
public class Solution_141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 为了避免null == null，在while做了!=null的判断
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

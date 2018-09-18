package yzl.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 */
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            if (slow == slow.next) return true;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow && fast != null) return true;
        }
        return false;
    }
}

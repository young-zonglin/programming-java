package yzl.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution_142_环形链表2 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> records = new HashSet<>();
        while (head != null) {
            if (records.contains(head)) {
                return head;
            } else {
                records.add(head);
                head = head.next;
            }
        }
        return null;
    }
}

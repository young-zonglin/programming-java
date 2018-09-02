package yzl.leetcode;

/**
 * Reverse linked list between m and n by one traversal.
 */
public class Solution_92 {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        ListNode head = ListNode.createLinkedList(arr);
        ListNode.showLinkedList(head, "forward");
        head = new Solution_92().reverseBetween(head, 1, 5);
        ListNode.showLinkedList(head, "reserve");
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = null, end = null, tail = null, cur = head, next;
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
                ListNode oldLast = tail;
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
}

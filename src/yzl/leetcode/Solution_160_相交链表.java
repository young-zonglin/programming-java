package yzl.leetcode;

public class Solution_160_相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先判断谁比较长，把长的先走到和短的一样长
        int aLen = 0;
        ListNode curA = headA;
        while (curA != null) {
            aLen++;
            curA = curA.next;
        }
        int bLen = 0;
        ListNode curB = headB;
        while (curB != null) {
            bLen++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        if (aLen > bLen) {
            for (int i = 1; i <= aLen - bLen; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 1; i <= bLen - aLen; i++) {
                curB = curB.next;
            }
        }

        // 开始判断
        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}

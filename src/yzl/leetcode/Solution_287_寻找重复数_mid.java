package yzl.leetcode;

/*
 * 技巧题，将数组看成没有值的链表，再通过快慢指针找到在哪里形成环
 */
public class Solution_287_寻找重复数_mid {
    public int findDuplicate(int[] nums) {
        // 1 3 2 4 2 4 2 4 2 => 2是环的开始
        // 3 4 2 3 4 2 3 4 2 => 3是环的开始
        // 3 3 3
        // 快慢指针，表示指向哪个节点，如果fast==slow，则他们指向同一个节点
        // nums[index]，即指向下一个节点了
        int fast = 0, slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int ptr = 0;
        while (ptr != fast) {
            ptr = nums[ptr];
            fast = nums[fast];
        }
        return ptr;
    }

    public static void main(String[] args) {
        // 将数组看成没有值的链表，head=0，即指向第一个节点，nums[index]则指向下一个节点
        int[] nums = {1, 3, 4, 2, 2};
        int ans = new Solution_287_寻找重复数_mid().findDuplicate(nums);
        System.out.println(ans);
    }
}

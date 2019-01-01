package com.medium.removeDuplicatesFromSortedListII;

import com.structure.ListNode.ListNode;


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = head;
        ListNode pre = FakeHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                //这里说明pre和cur指向的两个数是不同的，那么pre直接向下移动就好了
                pre = pre.next;
            } else {
                //这里说明cur已经经历过多个相同的数值了，那么这些数值全部不要。
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return FakeHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->1->1");
        ListNode.print(solution.deleteDuplicates(head));
    }
}

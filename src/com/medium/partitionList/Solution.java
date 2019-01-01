package com.medium.partitionList;

import com.structure.ListNode.ListNode;


public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode big = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode cur1 = big;
        ListNode cur2 = small;
        while (head != null) {
            ListNode tmp = new ListNode();
            tmp.val = head.val;
            if (tmp.val >= x) {
                cur1.next = tmp;
                cur1 = cur1.next;
            } else {
                cur2.next = tmp;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = big.next;
        return small.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->4->3->2->5->2");
        int x = 3;
        ListNode.print(solution.partition(head, x));
    }
}

package com.medium.reverseLinkedListII;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        for (int i = 0; i < m - 1; i++) {
            //不停移动pre  直到pre到达要开始逆序的之前的那个数
            pre = pre.next;
        }

        //start指向将要换的那个数  nex指向start的下一个数
        ListNode start = pre.next;
        ListNode nex = start.next;

        //开始执行n-m次
        for (int i = 0; i < n - m; i++) {
            start.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
            nex = start.next;
            ListNode.print(head);
        }

        return fakeHead.next;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->2->3->4->5->6->7->8->9");
        int m = 2;
        int n = 8;
        solution.reverseBetween(head, m, n);
    }
}

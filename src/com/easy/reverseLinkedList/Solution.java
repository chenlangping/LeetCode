package com.easy.reverseLinkedList;

import com.structure.ListNode.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->2->3->4->5->6");
        ListNode.print(solution.reverseList2(head));
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = null;
        ListNode tmp;
        while (cur != null) {
            tmp = cur;
            cur = cur.next;
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }
        return fakeHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
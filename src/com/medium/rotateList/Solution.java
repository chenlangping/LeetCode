package com.medium.rotateList;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        ListNode tmp;
        int len = getListNodeLength(head);
        int pace = k % len;
        for (int i = 0; i < len - pace - 1; i++) {
            p = p.next;
        }
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        tmp = p.next;
        p.next = null;
        return tmp;
    }

    public static int getListNodeLength(ListNode listNode) {
        int length = 0;
        if (listNode == null) {
            return 0;
        }
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("");
        int k = 0;
        ListNode.print(solution.rotateRight(head, k));
    }
}

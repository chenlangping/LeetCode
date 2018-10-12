package com.hard.reverseNodesInKGroup;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode listNode = new ListNode(0);
        ListNode start = listNode;
        listNode.next = head;
        while (true) {
            ListNode p = start;
            ListNode q;
            ListNode cur = p;
            start = p.next;
            for (int i = 0; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if (cur == null) {
                break;
            }
            for (int i = 0; i < k - 1; i++) {
                q = p.next;
                p.next = q.next;
                q.next = cur.next;
                cur.next = q;
            }
        }
        return listNode.next;
    }
}
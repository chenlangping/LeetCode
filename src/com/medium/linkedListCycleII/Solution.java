package com.medium.linkedListCycleII;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // found cycle
                ListNode listNode = head;
                while (listNode != slow) {
                    listNode = listNode.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

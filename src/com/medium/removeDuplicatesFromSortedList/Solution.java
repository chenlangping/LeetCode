package com.medium.removeDuplicatesFromSortedList;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode result = current;
        if (null == current) {
            return null;
        }
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return result;
    }
}

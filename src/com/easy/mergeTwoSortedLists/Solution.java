package com.easy.mergeTwoSortedLists;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //如果其中一个已经有序，那么直接返回另外一个就行了
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = new ListNode(0);
        ListNode current = head;
        //谁长就把谁放进去
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                current.next = l2;
                l2 = l2.next;
            } else {
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }

        //此时有一个已经是Null了
        while (l1 != null) {
            current.next = l1;
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = l2;
            l2 = l2.next;
            current = current.next;
        }

        return head.next;
    }

    /*
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode0 = ListNode.createTestData("1->3->5->7->9");
        ListNode listNode1 = ListNode.createTestData("2->4->6->8->10");
        ListNode.print(listNode0);
        ListNode.print(listNode1);
        ListNode.print(solution.mergeTwoLists(listNode0, listNode1));
    }
    */
}

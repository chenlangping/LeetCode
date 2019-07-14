package com.easy.intersectionOfTwoLinkedLists;

import com.structure.ListNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode headA = ListNode.createTestData("1->2->3->4");
        ListNode headB = ListNode.createTestData("1->2->4");
        headA.next = new ListNode(5);
        headB.next = headA.next;
        System.out.println(solution.getIntersectionNode3(headA, headB).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        while (l1 != null) {
            ListNode l2 = headB;
            while (l2 != null) {
                if (l1 == l2) {
                    return l1;
                } else {
                    l2 = l2.next;
                }
            }
            l1 = l1.next;
        }

        return l1;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode l1 = headA, l2 = headB;
        while (l1 != null) {
            set.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if (set.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }
        return null;
    }
}

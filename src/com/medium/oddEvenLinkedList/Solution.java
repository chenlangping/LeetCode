package com.medium.oddEvenLinkedList;

import com.structure.ListNode.ListNode;


/**
 * @author chenlangping
 * @date 2019-06-09
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->2->3->4->5");
        ListNode.print(solution.oddEvenList(head));
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode cur = head;
        ListNode odd = new ListNode(0);
        ListNode p1 = odd;
        ListNode even = new ListNode(0);
        ListNode p2 = even;
        int count = 0;
        while (cur != null) {
            count++;
            if (count % 2 == 1) {
                odd.next = cur;
                odd = odd.next;
            } else {
                even.next = cur;
                even = even.next;
            }
            cur = cur.next;
        }
        odd.next = p2.next;
        even.next = null;
        return p1.next;

    }
}

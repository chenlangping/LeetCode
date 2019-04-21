package com.medium.insertionSortList;

import com.structure.ListNode.ListNode;

/**
 * @author chenlangping
 * @date 2019-04-21
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {-1, 5, 3, 4, 0};
        ListNode head = ListNode.createTestData(data);
        ListNode.print(solution.insertionSortList(head));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode cur = head.next;
        ListNode pcur = head;
        ListNode pre;
        ListNode next;
        fakeHead.next = head;
        while (cur != null) {
            pre = fakeHead;
            next = fakeHead.next;
            while (cur.val > next.val) {
                next = next.next;
                pre = pre.next;
            }

            if (cur == next) {
                cur = cur.next;
                pcur = pcur.next;
                continue;
            }
            ListNode tmp = cur;
            cur = cur.next;
            pcur.next = cur;
            pre.next = tmp;
            tmp.next = next;

        }
        return fakeHead.next;
    }
}

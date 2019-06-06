package com.easy.removeLinkedListElements;

import com.structure.ListNode.ListNode;

/**
 * @author chenlangping
 * @date 2019-06-06
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createTestData("1");
        int val = 1;
        ListNode.print(solution.removeElements(listNode, val));
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }

        return fakeHead.next;
    }
}

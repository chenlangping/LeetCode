package com.medium.swapNodesInPairs;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode();
        result.next = head;
        ListNode cur = result;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            ListNode temp2 = cur.next.next;
            //将第一个节点接上第三个节点
            temp.next = temp2.next;
            //将第零个节点接上第二个节点
            cur.next = temp2;
            //将第二个节点接上第一个节点
            cur.next.next = temp;
            //移动当前节点
            cur = cur.next.next;
        }
        return result.next;

    }
}
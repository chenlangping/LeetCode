package com.medium.removeNthNodeFromEndOfList;

import com.structure.ListNode.ListNode;


public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        int count = 0;
        int position;
        listNode.next = head;
        ListNode node = listNode;
        //第一趟记录下一共有多少节点
        while (node.next != null) {
            count++;
            node = node.next;
        }
        node = listNode;
        position = count - n;
        count = 0;
        //第二趟找到要删掉的节点
        while (position != count) {
            node = node.next;
            count++;
        }
        //删除操作
        node.next = node.next.next;
        return listNode.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode listNode1 = listNode;
        ListNode listNode2 = listNode;
        //先让listNode1先跑一段
        for (int i = 0; i < n; i++) {
            listNode1 = listNode1.next;
        }
        //当listNode1到达末尾的时候，listNode2正好在要删除的节点的前面一个
        while (listNode1.next != null) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        //删除节点操作
        listNode2.next = listNode2.next.next;

        return listNode.next;

    }
}

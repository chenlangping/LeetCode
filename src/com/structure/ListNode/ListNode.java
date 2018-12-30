package com.structure.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode() {
        val = 0;
    }

    public static ListNode createTestData(String data) {
        if (data.equals("")) return null;
        //用->作为分隔符
        String[] split = data.split("->");
        int len = split.length;
        ListNode[] listNode = new ListNode[len + 1];
        listNode[0] = new ListNode(Integer.valueOf(split[0]));
        for (int i = 1; i < len; i++) {
            listNode[i] = new ListNode(Integer.valueOf(split[i]));
            listNode[i - 1].next = listNode[i];
        }
        //listNode[len] = null;不需要 默认就是Null
        return listNode[0];
    }

    /**
     * 打印一个指定链表的所有内容
     *
     * @param listNode
     */
    public static void print(ListNode listNode) {
        if (listNode == null) {
            System.out.println("null");
            return;
        }
        StringBuilder str = new StringBuilder(String.valueOf(listNode.val));
        ListNode p = listNode.next;
        while (p != null) {
            str.append("->").append(String.valueOf(p.val));
            p = p.next;
        }
        System.out.println(str);
    }

    /**
     * 求指定链表的长度
     * @param listNode
     * @return 链表的长度
     */
    public static int getListNodeLength(ListNode listNode) {
        int length = 0;
        if (listNode == null) {
            return 0;
        }
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }
}
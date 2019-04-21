package com.structure.ListNode;


public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createTestData(String data) {
        if ("".equals(data)) {
            return null;
        }
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

    public static ListNode createTestData(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int datum : data) {
            stringBuilder.append("->").append(datum);
        }
        return createTestData(stringBuilder.toString().substring(2));
    }

    /**
     * 打印一个指定链表的所有内容
     *
     * @param head 链表头部
     */
    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        StringBuilder str = new StringBuilder(String.valueOf(head.val));
        ListNode p = head.next;
        while (p != null) {
            str.append("->").append(p.val);
            p = p.next;
        }
        System.out.println(str);
    }

    /**
     * 求指定链表的长度
     *
     * @param head 链表头部
     * @return 链表的长度
     */
    public static int getListNodeLength(ListNode head) {
        int length = 0;
        if (head == null) {
            return 0;
        }
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
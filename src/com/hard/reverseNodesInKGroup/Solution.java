package com.hard.reverseNodesInKGroup;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k < 2) {
            return head;
        }
        ListNode listNode = new ListNode();
        listNode.next = head;
        if (head.next == null) {
            return null;
        }
        ListNode cur = head.next;
        ListNode flag = cur;
        int i = 1;
        while (cur.next != null) {
            i++;
            if (k == i) {
                i = 1;
                //在这里执行reverse操作
                flag = cur;
                break;
            }
            cur = cur.next;
        }
        System.out.println(cur.val);

        return listNode.next;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode prev = dummy;
        ListNode temp;
        int count;
        while (true) {
            count = k;
            while (count > 0 && tail != null) {
                count--;
                tail = tail.next;
            }
            if (tail == null) break;//Has reached the end
            head = prev.next;//for next cycle
            // prev-->temp-->...--->....--->tail-->....
            // Delete @temp and insert to the next position of @tail
            // prev-->...-->...-->tail-->head-->...
            // Assign @temp to the next node of @prev
            // prev-->temp-->...-->tail-->...-->...
            // Keep doing until @tail is the next node of @prev
            while (prev.next != tail) {
                temp = prev.next;//Assign
                prev.next = temp.next;//Delete

                temp.next = tail.next;
                tail.next = temp;//Insert
            }

            tail = head;
            prev = head;

        }
        return dummy.next;

    }

}
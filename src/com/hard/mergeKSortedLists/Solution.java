package com.hard.mergeKSortedLists;

import com.structure.ListNode.ListNode;


public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        while(!isEmpty(lists)){
            head.next = findMinimumListNode(lists);
            head = head.next;
        }
        return result.next;
    }

    /*
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.createTestData("1->3->6");
        lists[1] = ListNode.createTestData("2->6->8");
        lists[2] = ListNode.createTestData("5->100");
        Solution solution = new Solution();
        ListNode.print(solution.mergeKLists(lists));
    }
    */

    public ListNode findMinimumListNode(ListNode[] lists){
        ListNode result = new ListNode(0);
        int j = 0;
        int min = 0 ;
        for(int i = 0 ;i<lists.length;i++){
            if (lists[i]!=null){
                min = lists[i].val;
                break;
            }
        }

        for(int i = 0 ;i<lists.length;i++){
            if (lists[i]!=null){
                //首先确定这个链表还是存在的
                if(lists[i].val <= min){
                    j=i;
                    min = lists[i].val;
                }
            }
        }

        //找出最小的了
        result.next = lists[j];
        lists[j] = lists[j].next;
        return result.next;
    }

    public boolean isEmpty(ListNode[] lists){
        int count = 0;
        for(int i = 0 ;i<lists.length;i++){
            if (lists[i]==null){
               count++;
            }
        }

        if(lists.length == count){
            return true;
        }else {
            return false;
        }
    }
}

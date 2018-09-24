package com.test;

import com.medium.removeNthNodeFromEndOfList.*;
import com.structure.ListNode.ListNode;


public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createTestData("1->2->3->4->5");
        ListNode.print(solution.removeNthFromEnd(listNode,3));
    }


}

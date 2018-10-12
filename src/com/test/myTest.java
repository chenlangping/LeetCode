package com.test;

import com.hard.reverseNodesInKGroup.Solution;
import com.structure.ListNode.ListNode;


public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createTestData("1->2->3->4->5->6");
        int k = 3;
        ListNode.print(solution.reverseKGroup(listNode, k));
        ListNode.print(solution.reverseKGroup2(listNode, k));


    }


}

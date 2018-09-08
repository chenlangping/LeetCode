package com.test;

import com.medium.removeDuplicatesFromSortedList.Solution;
import com.structure.ListNode.ListNode;

public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = ListNode.createTestData("1->1->2->3->3");
        ListNode.print(solution.deleteDuplicates(listNode));
    }


}

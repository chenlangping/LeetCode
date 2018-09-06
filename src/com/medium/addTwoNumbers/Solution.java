package com.medium.addTwoNumbers;

import com.structure.ListNode.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode result = node;
        //分别用n1指向l1，n2指向l2，并用result指向最后的答案
        int sum = 0;
        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            result.next = new ListNode(sum % 10);
            result = result.next;
        }

        //如果到了最后两位相加还是超过了10，最后再补一个“1”
        if (sum / 10 != 0) result.next = new ListNode(1);
        return node.next;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.createTestData("1->3->5->7->9");
        ListNode l2 = ListNode.createTestData("1->5->5->7->9");
        ListNode.print(solution.addTwoNumbers(l1, l2));
    }
}

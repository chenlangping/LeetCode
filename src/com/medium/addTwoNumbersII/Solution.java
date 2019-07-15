package com.medium.addTwoNumbersII;

import com.structure.ListNode.ListNode;

import java.util.LinkedList;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.createTestData("8->6");
        ListNode l2 = ListNode.createTestData("6->4->8");
        ListNode.print(solution.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<Integer> stack1 = getStackFromListNode(l1);
        LinkedList<Integer> stack2 = getStackFromListNode(l2);
        int flag = 0;
        ListNode fakeHead = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int res = flag;
            if (!stack1.isEmpty()) {
                res += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                res += stack2.pop();
            }
            if (res > 9) {
                flag = 1;
            } else {
                flag = 0;
            }
            ListNode tmp = new ListNode(res % 10);
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }


        if (flag == 1) {
            ListNode tmp = new ListNode(1);
            tmp.next = fakeHead.next;
            fakeHead.next = tmp;
        }

        return fakeHead.next;
    }

    private LinkedList<Integer> getStackFromListNode(ListNode l) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }
}

package com.easy.palindromeLinkedList;

import com.structure.ListNode.ListNode;

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("1->2->2->1");
        System.out.println(solution.isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> deque = new LinkedList<>();
        ListNode fakeHead = head;
        while (head != null) {
            deque.addLast(head.val);
            head = head.next;
        }
        while (!deque.isEmpty()) {
            if (deque.size() == 1) {
                return true;
            }
            int start = deque.getFirst();
            int end = deque.getLast();
            deque.removeFirst();
            deque.removeLast();
            if (start != end) {
                return false;
            }
        }
        return true;
    }
}

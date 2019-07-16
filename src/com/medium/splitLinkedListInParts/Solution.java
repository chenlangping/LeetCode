package com.medium.splitLinkedListInParts;

import com.structure.ListNode.ListNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        ListNode root = ListNode.createTestData(data);
        ListNode[] res = solution.splitListToParts(root, 8);
        for (int i = 0; i < res.length; i++) {
            ListNode.print(res[i]);
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode cur = root;
        ListNode pre = null;
        int length = getListNodeLength(root);
        int eachLength = length / k;
        int r = length % k;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < r; i++) {
            //each length = eachLength+1
            res[i] = cur;
            for (int j = 0; j < eachLength + 1; j++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        }
        for (int i = r; i < k; i++) {
            //each length = eachLength
            if (cur == null) {
                return res;
            }
            res[i] = cur;
            for (int j = 0; j < eachLength; j++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = null;
        }

        return res;
    }

    private int getListNodeLength(ListNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.next;
        }
        return count;
    }
}
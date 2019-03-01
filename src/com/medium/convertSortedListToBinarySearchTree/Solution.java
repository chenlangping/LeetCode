package com.medium.convertSortedListToBinarySearchTree;

import com.structure.ListNode.ListNode;
import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            res.add(cur.val);
            cur = cur.next;
        }
        return recursive(res, 0, res.size() - 1);
    }

    public TreeNode recursive(List<Integer> res, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = recursive(res, low, mid - 1);
        root.right = recursive(res, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.createTestData("-10->-3->0->5->9");
        TreeNode.print(solution.sortedListToBST(head));
    }
}

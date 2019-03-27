package com.medium.binaryTreePreorderTraversal;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6,7,8]");
        System.out.println(solution.preorderTraversal(root));
    }
}
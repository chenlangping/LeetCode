package com.easy.balancedBinaryTree;

import com.structure.TreeNode.TreeNode;

public class Solution {

    private boolean isBanlanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBanlanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBanlanced = false;
        }
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        TreeNode root2 = TreeNode.createTestData("[1,2,2,3,3,null,null,4,4]");
        System.out.println(solution.isBalanced(root2));
    }
}

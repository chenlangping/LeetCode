package com.easy.diameterOfBinaryTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    int globalMax = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTestData("[1,2,3,4,5,6,7]");
        System.out.println(solution.diameterOfBinaryTree(treeNode));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return globalMax;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = helper(root.left);
            int right = helper(root.right);
            globalMax = Math.max(globalMax, left + right);
            return Math.max(left, right) + 1;
        }
    }
}

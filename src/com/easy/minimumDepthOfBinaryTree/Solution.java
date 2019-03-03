package com.easy.minimumDepthOfBinaryTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        if (left == 0) {
            return right + 1;
        }
        if (right == 0) {
            return left + 1;
        }

        int min = Math.min(left, right);
        return min + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[1,2]");
        System.out.println(solution.minDepth(root));
    }
}

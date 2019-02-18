package com.easy.invertBinaryTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            invertTree(left);
            invertTree(right);
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[4,2,7,1,3,6,9]");
        TreeNode.print(root);
        System.out.println("--------------------------");
        TreeNode.print(solution.invertTree(root));
    }

}

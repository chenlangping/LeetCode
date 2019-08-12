package com.medium.lowestCommonAncestorOfABinaryTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(5);
        // it is wrong, if you want to use this, you should change root==p to root.val == p.val
        System.out.println(solution.lowestCommonAncestor(root, p, q).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}

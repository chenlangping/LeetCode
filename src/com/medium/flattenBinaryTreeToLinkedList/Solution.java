package com.medium.flattenBinaryTreeToLinkedList;

import com.structure.TreeNode.TreeNode;

public class Solution {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        //为什么是先右子树后左子树？因为这是从叶子开始构造的，而如果是从根开始是先左子树而后右子树的
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[1,2,5,3,4,null,6]");
        solution.flatten(root);
        TreeNode.print(root);
    }
}
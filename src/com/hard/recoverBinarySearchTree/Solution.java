package com.hard.recoverBinarySearchTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        //接下来是遍历中“应该打印的地方”

        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;

        //“打印结束”

        traverse(root.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTestData("[3,1,4,null,null,2]");
        solution.recoverTree(treeNode);
        TreeNode.print(treeNode);
    }
}
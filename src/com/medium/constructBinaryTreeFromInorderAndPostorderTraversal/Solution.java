package com.medium.constructBinaryTreeFromInorderAndPostorderTraversal;

import com.structure.TreeNode.TreeNode;

public class Solution {

    private int index = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return build(inorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        if (start == end) {
            return root;
        }

        int index = findIndex(inorder, root.val, end);
        root.right = build(inorder, postorder, index + 1, end);
        root.left = build(inorder, postorder, start, index - 1);
        return root;
    }

    private int findIndex(int[] inorder, int val, int end) {
        for (int i = end; i >= 0; i--) {
            if (inorder[i] == val) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int inorder[] = {9, 3, 15, 20, 7};
        int postorder[] = {9, 15, 7, 20, 3};
        TreeNode.print(solution.buildTree(inorder, postorder));
    }
}

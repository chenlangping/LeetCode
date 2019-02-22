package com.medium.constructBinaryTreeFromPreorderAndInorderTraversal;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursive(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode recursive(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart >= inorder.length || preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);

        //找到分割点的下标
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }

        root.left = recursive(preorder, preStart + 1, preorder.length, inorder, inStart, index - 1);
        root.right = recursive(preorder, preStart + index - inStart + 1, preorder.length, inorder, index + 1, inEnd);
        return root;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int preorder[] = {3, 9, 20, 15, 7};
        int inorder[] = {9, 3, 15, 20, 7};
        TreeNode.print(solution.buildTree(preorder, inorder));
    }
}

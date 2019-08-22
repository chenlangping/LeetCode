package com.easy.convertBSTToGreaterTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    int globalSum = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[5,2,13]");
        TreeNode.print(solution.convertBST(root));
    }

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null) {
            return;
        }
        convert(cur.right);
        cur.val += globalSum;
        globalSum = cur.val;
        convert(cur.left);
    }
}

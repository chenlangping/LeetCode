package com.easy.pathSum;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,null,null,1]");
        System.out.println(solution.hasPathSum(treeNode, 22));
    }
}

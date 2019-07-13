package com.easy.pathSumIII;

import com.structure.TreeNode.TreeNode;

public class Solution {

    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        helper(root, sum, 0);
        //以下两句是关键
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return count;
    }

    private void helper(TreeNode root, int sum, int cur) {
        if (root == null) {
            return;
        }
        cur += root.val;
        if (cur == sum) {
            count++;
        }
        if (root.left != null) {
            helper(root.left, sum, cur);
        }
        if (root.right != null) {
            helper(root.right, sum, cur);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[10,5,-3,3,2,null,11,3,-2,null,1]");
        System.out.println(solution.pathSum(root, 8));
    }
}

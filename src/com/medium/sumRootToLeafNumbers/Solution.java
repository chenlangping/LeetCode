package com.medium.sumRootToLeafNumbers;

import com.structure.TreeNode.TreeNode;

/**
 * @author chenlangping
 * @date 2019-06-07
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[4,9,0,5,1]");
        System.out.println(solution.sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    private int helper(TreeNode root, int tmpSum) {
        // when reach leaf
        if (root.left == null && root.right == null) {
            return tmpSum * 10 + root.val;
        }

        // Recursive
        int res = 0;
        if (root.left != null) {
            res += helper(root.left, 10 * tmpSum + root.val);
        }
        if (root.right != null) {
            res += helper(root.right, 10 * tmpSum + root.val);
        }
        return res;
    }

}

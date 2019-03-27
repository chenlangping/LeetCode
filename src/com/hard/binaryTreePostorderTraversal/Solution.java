package com.hard.binaryTreePostorderTraversal;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.left!=null){
            helper(root.left,res);
        }
        if (root.right!=null){
            helper(root.right,res);
        }
        res.add(root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[1,2,3,4,5,6,7,8]");
        System.out.println(solution.postorderTraversal(root));
    }
}

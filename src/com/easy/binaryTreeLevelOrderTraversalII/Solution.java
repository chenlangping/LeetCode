package com.easy.binaryTreeLevelOrderTraversalII;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (q.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        Solution solution = new Solution();
        System.out.println(solution.levelOrderBottom(treeNode));

    }
}

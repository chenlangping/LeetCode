package com.medium.uniqueBinarySearchTreesII;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return recursive(1, n);
    }

    public List<TreeNode> recursive(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        List<TreeNode> left, right;

        // 结束条件
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        //开始递归
        for (int i = start; i <= end; i++) {
            left = recursive(start, i - 1);
            right = recursive(i + 1, end);

            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<TreeNode> list = solution.generateTrees(0);
        for (TreeNode treeNode : list) {
            TreeNode.print(treeNode);
            System.out.println();
            System.out.println("----------------");
        }
    }
}

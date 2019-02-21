package com.medium.binaryTreeZigzagLevelOrderTraversal;

import com.structure.TreeNode.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        boolean turn = true;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (turn) {
                //从左到右
                turn = false;
                List<Integer> tmp = new ArrayList<>();
                int queueLen = queue.size();
                for (int i = 0; i < queueLen; i++) {
                    if (queue.getFirst().left != null) {
                        queue.addLast(queue.getFirst().left);
                    }
                    if (queue.getFirst().right != null) {
                        queue.addLast(queue.getFirst().right);
                    }
                    tmp.add(queue.removeFirst().val);
                }
                res.add(tmp);
            } else {
                //从右到左
                turn = true;
                List<Integer> tmp = new ArrayList<>();
                int queueLen = queue.size();
                for (int i = 0; i < queueLen; i++) {
                    if (queue.getLast().right != null) {
                        queue.addFirst(queue.getLast().right);
                    }
                    if (queue.getLast().left != null) {
                        queue.addFirst(queue.getLast().left);
                    }
                    tmp.add(queue.removeLast().val);
                }
                res.add(tmp);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        //TreeNode.print(treeNode);
        System.out.println(solution.zigzagLevelOrder(treeNode));
    }
}

package com.medium.binaryTreeLevelOrderTraversal;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (null == root) {
            return res;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            //用一个变量来记录当前的queue的长度，这里很重要，因为queue一直在变！
            int queueLen = queue.size();
            for (int i = 0; i < queueLen; i++) {
                //对于每一个节点，我们先把它的左右加入进来，然后把它删除，相当于一层一层进行处理
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                tmp.add(queue.poll().val);
            }
            res.add(tmp);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = TreeNode.createTestData("[3,9,20,null,null,15,7]");
        //TreeNode.print(treeNode);
        System.out.println(solution.levelOrder(treeNode));
    }
}

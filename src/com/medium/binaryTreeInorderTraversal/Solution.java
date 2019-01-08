package com.medium.binaryTreeInorderTraversal;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 中序遍历二叉树 即左子树-根-右子树
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode cur, List<Integer> list) {
        if (cur == null) {
            return;
        } else {
            inorder(cur.left, list);
            list.add(cur.val);
            inorder(cur.right, list);
        }
    }
}

package com.easy.sameTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = false;

        if (p == null && q == null) {
            //两个都为空说明是相等的
            return true;
        } else if (p == null || q == null) {
            //一个空一个非空说明不相等
            return false;
        }

        //值相同则递归判断
        if (p.val == q.val) {
            result = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

        return result;
    }
}
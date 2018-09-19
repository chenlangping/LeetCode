package com.test;

import com.easy.sameTree.*;
import com.structure.TreeNode.TreeNode;


public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode p = TreeNode.createTestData("[1,2,3]");
        TreeNode q = TreeNode.createTestData("[2,3,1]");
        System.out.println(solution.isSameTree(p,q));
        //TreeNode.print(p);
    }


}

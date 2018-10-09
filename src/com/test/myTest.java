package com.test;

import com.easy.maximumDepthOfBinaryTree.Solution;
import com.structure.TreeNode.TreeNode;


public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[2,3,3,4,null,4,null,5,5,null,null,5,null,null,null]");
        System.out.println(solution.maxDepth(root));
    }


}

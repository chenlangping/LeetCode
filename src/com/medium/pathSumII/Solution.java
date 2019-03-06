package com.medium.pathSumII;

import com.structure.TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> finalResult = new ArrayList<>();
        List<Integer> tmpResult = new ArrayList<>();
        recursive(root, sum, finalResult, tmpResult);
        return finalResult;
    }

    public void recursive(TreeNode root, int sum, List<List<Integer>> finalResult
            , List<Integer> tmpResult) {
        if (null == root) {
            return;
        }
        tmpResult.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            finalResult.add(new ArrayList<>(tmpResult));
            tmpResult.remove(tmpResult.size() - 1);
            return;
        } else {
            recursive(root.left, sum - root.val, finalResult, tmpResult);
            recursive(root.right, sum - root.val, finalResult, tmpResult);
        }
        tmpResult.remove(tmpResult.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,null,5,1]");
        int sum = 22;
        System.out.println(solution.pathSum(root, sum));
    }
}
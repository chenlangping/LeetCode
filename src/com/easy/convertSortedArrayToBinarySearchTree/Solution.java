package com.easy.convertSortedArrayToBinarySearchTree;

import com.structure.TreeNode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursive(nums, 0, nums.length - 1);
    }

    public TreeNode recursive(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int mid = (low + high) >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursive(nums, low, mid - 1);
        root.right = recursive(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {-10, -3, 0, 5, 9};
        TreeNode.print(solution.sortedArrayToBST(nums));
    }
}
package com.medium.nextPermutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        //i用来记录从右边开始的第一个递减的下标
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            //i=-1的时候说明整个数组都是降序的
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            System.out.println("j= " + j);
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * 将从start开始的数组，按从小到大的顺序排列
     *
     * @param nums  目标数组
     * @param start 开始位置
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    /**
     * 交换数组指定位置的数
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

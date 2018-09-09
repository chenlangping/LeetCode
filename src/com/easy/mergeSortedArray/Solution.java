package com.easy.mergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //i指向最后的nums1的最后一个真实的数，j指向nums2的最后一个数，k指向nums1的末尾
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            //如果nums1比较大，那么就放入nums1的数据
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                //否则放入nums2的数据
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        //最后如果nums1有剩余，那么不用管；如果是num2有剩余，那么依次放入即可
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }
}

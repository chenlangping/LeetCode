package com.hard.medianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (0 == nums1.length) {
            return getMedian(nums2);
        }
        if (0 == nums2.length) {
            return getMedian(nums1);
        }

        //现在确保两个都是不空的了
        int[] result = new int[nums1.length + nums2.length];
        //ijk分别记录nums1、nums2和result的下标
        int i = 0;
        int j = 0;
        int k = 0;
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] > nums2[j]) {
                result[k] = nums2[j];
                k++;
                j++;
            } else {
                result[k] = nums1[i];
                k++;
                i++;
            }
        }

        if (i == nums1.length) {
            while (j != nums2.length) {
                result[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (j == nums2.length) {
            while (i != nums1.length) {
                result[k] = nums1[i];
                k++;
                i++;
            }
        }

        return getMedian(result);
    }

    public double getMedian(int[] nums) {
        int medium = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (double) (nums[medium] + nums[medium - 1]) / 2;
        } else {
            return (double) nums[medium];
        }
    }

    /**
     * 仅适用于两个长度相同的数组找中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int k = (nums1.length + nums2.length) / 2;
        return getMedian(k, nums1, nums2, 0, 0);
    }

    public double getMedian(int k, int[] nums1, int[] nums2, int start1, int start2) {
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        k = k / 2;
        if (nums1[start1 + k] < nums2[start2 + k]) {
            return getMedian(k, nums1, nums2, start1 + k, start2);
        } else {
            return getMedian(k, nums1, nums2, start1, start2 + k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3, 4, 6, 10};
        int[] nums2 = {2, 5, 7, 8, 9};
        System.out.println(solution.findMedianSortedArrays2(nums1, nums2));
    }
}

package com.hard.medianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 ){
            return getMedian(nums2);
        }
        if(nums2.length == 0 ){
            return getMedian(nums1);
        }

        //现在确保两个都是不空的了
        int []result = new int[nums1.length+nums2.length];
        //ijk分别记录nums1 nums2 result的下标
        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        while( i!=nums1.length && j != nums2.length){
            if (nums1[i] > nums2[j]){
                result[k] = nums2[j];
                k++;
                j++;
            }else {
                result[k] = nums1[i];
                k++;
                i++;
            }
        }

        if (i == nums1.length){
            while(j!= nums2.length){
                result[k] = nums2[j];
                k++;
                j++;
            }
        }

        if (j == nums2.length){
            while(i!= nums1.length){
                result[k] = nums1[i];
                k++;
                i++;
            }
        }

        return getMedian(result);
    }

    public double getMedian(int [] nums){
        int medium = nums.length/2;
        if(nums.length%2 == 0 ){
            return (double) (nums[medium] + nums[medium - 1]) / 2;
        }else{
            return (double) nums[medium];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums1 = {};
        int []nums2 = {2,5,7,8,9,10};
        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
    }
}

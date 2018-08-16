package com.medium.searchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int small = 0;
        int big = nums.length-1;
        int mid = 0;

        while(big >=small){
            mid = (big+small)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[small]<=nums[mid]){
                //此时左半部分一定是递增的
                if (target < nums[mid] && target >= nums[small]) {
                    big = mid - 1;
                }else {
                    small = mid + 1;
                }
            }else{
                //此时在mid的右边是递增的
                if(target>nums[mid] && target<= nums[big]){
                    small = mid +1;
                }else {
                    big = mid -1;
                }
            }

        }
        return -1;


    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]= {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(solution.search(nums,target));
    }
}
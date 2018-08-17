package com.medium.findFirstAndLastPositionOfElementinSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int small =0;
        int big = nums.length-1;
        int mid = binarySearch(nums,target);
        int [] result = {-1,-1};
        if(-1 == mid ){
            return result;
        }else {
            int left = mid;
            int right = mid;
            result[0] = left;
            result[1] = right;
            while(left>=1){
                if(nums[left] == nums[left-1]){
                    left --;
                }else {
                    result[0] = left;
                    break;
                }
                //这句至关重要
                result[0] = left;
            }
            while(right<nums.length-1){
                if(nums[right] == nums[right+1]){
                    right ++;
                }else {
                    result[1] = right;
                    break;
                }
                //这句至关重要
                result[1] = right;
            }
            return result;
        }

    }

    private int binarySearch(int[] nums, int target){
        int small =0;
        int big = nums.length-1;
        int mid = 0;
        int result = -1;
        while(big >= small){
            mid = (big+small)/2;
            if(nums[mid] == target){
                result = mid;
                return result;
            }else if (nums[mid] > target){
                big = mid - 1;
            }else {
                small = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[]={2,2};
        int target = 2;
        System.out.println(solution.binarySearch(nums,target));
        int []result = {-1,-1};
        result = solution.searchRange(nums,target);
        System.out.println(result[0]+" "+result[1]);
    }
}

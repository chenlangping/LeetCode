package com.medium.threeSum;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ;i<nums.length-2;i++){
            if( i==0 || nums[i]!=nums[i-1]){
                int small = i+1;
                int big = nums.length-1;
                int sum = 0-nums[i];
                while(big >small){
                    if(sum == (nums[big]+nums[small])){
                        List list = new ArrayList();
                        list.add(nums[small]);
                        list.add(nums[i]);
                        list.add(nums[big]);
                        lists.add(new ArrayList<>(list));
                        //去重操作
                        while(big >small && nums[small]==nums[small+1]){
                            small++;
                        }
                        while(big >small && nums[big]==nums[big-1]){
                            big--;
                        }
                        big--;
                        small++;
                    }else if(sum > nums[big]+nums[small]){
                        small++;
                    }else {
                        big--;
                    }
                }

            }
        }

        return lists;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] ={-1,-1,-1,2,2};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }


}

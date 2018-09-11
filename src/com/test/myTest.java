package com.test;

import com.medium.nextPermutation.*;

import java.util.Arrays;
import java.util.List;

public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,4,3,2,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }


}

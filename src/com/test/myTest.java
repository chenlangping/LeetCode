package com.test;

import com.easy.mergeSortedArray.*;

import java.util.Arrays;

public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int []nums1 = {1,2,3,0,0,0};
        int m =3 ;
        int []nums2 = {2,5,6};
        int n = 3;
        solution.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }


}

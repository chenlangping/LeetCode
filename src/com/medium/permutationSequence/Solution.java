package com.medium.permutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String getPermutation(int n, int k) {
        int nums[] = new int[n];
        int des[] = new int[1];
        int cur[] = new int[1];
        cur[0] = 0;
        des[0] = k;
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        String s[] = new String[1];
        recursion(nums, cur, des, s, new ArrayList<>());
        return s[0];
    }

    private void recursion(int nums[], int[] cur, int[] des, String s[], List<Integer> tempList) {
        if (tempList.size() == nums.length) {
            if (cur[0] == des[0]-1) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < tempList.size(); j++) {
                    sb.append(tempList.get(j));
                }
                s[0] = sb.toString();
                cur[0]++;
                return;
            } else {
                cur[0]++;
            }

        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            recursion(nums, cur, des, s, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int k = 3;
        System.out.println(solution.getPermutation(n, k));
    }
}

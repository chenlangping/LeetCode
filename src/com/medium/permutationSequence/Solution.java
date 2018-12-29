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
            if (cur[0] == des[0] - 1) {
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

    public String getPermutation2(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 创建阶乘数组
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}


        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        //因为数组从0开始，所以第1个其实是第0个，所以需要k--
        k--;

        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int k = 3;
        System.out.println(solution.getPermutation2(n, k));
    }
}

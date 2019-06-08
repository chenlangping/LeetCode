package com.hard.slidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author chenlangping
 * @date 2019-06-08
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            //删除已经确定不在滑动窗口中的元素
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.removeFirst();
            }

            //删除一定不可能是最大的
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }

            //放入最新的一个
            queue.add(i);

            //写入最终的数组
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[queue.getFirst()];
            }

        }

        return res;
    }

    public int[] getMaxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int start = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[start] < nums[i]) {
                start = i - k + 1;
            }
        }
        return Arrays.copyOfRange(nums, start, start + k);
    }

}

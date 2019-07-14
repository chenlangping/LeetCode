package com.medium.findRightInterval;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 4}, {2, 3}, {3, 4}};
        System.out.println(Arrays.toString(solution.findRightInterval3(intervals)));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            boolean hasFound = false;
            int end = intervals[i][1];
            int minStart = Integer.MAX_VALUE;
            int minStartIndex = -1;
            //System.out.println("end = " + end);
            for (int j = 0; j < intervals.length; j++) {
                int start = intervals[j][0];
                //System.out.println("start = " + start);
                if (start >= end) {
                    hasFound = true;
                    if (start < minStart) {
                        minStart = start;
                        minStartIndex = j;
                    }
                }
            }
            if (!hasFound) {
                res[i] = -1;
            } else {
                res[i] = minStartIndex;
            }
        }

        return res;
    }

    public int[] findRightInterval2(int[][] intervals) {
        int[] res = new int[intervals.length];

        //1.建立索引
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        //2.按照start的大小进行排序
        List<Map.Entry<int[], Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(o -> o.getKey()[0]));

        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];

            //二分法查找

        }

        return res;

    }

    public int[] findRightInterval3(int[][] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            intervalMap.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }

        return result;
    }
}

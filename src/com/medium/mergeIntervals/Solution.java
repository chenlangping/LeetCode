package com.medium.mergeIntervals;

import com.structure.Interval.Interval;

import java.util.*;

public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        //因为之后有intervals.get(0).start，所以需要排除Null
        if (intervals.isEmpty()) {
            return intervals;
        }
        //先按start从小到大排
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<>();
        //result_start记录最大的区间的起始位置，result_end记录最大的区间末尾位置
        int result_start = intervals.get(0).start;
        int result_end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).start == intervals.get(i).start) {
                //找到相同的start中end最大的，就是整个区间最长的
                result_end = Math.max(intervals.get(i).end, result_end);
                continue;
            } else {
                //此时两个区间完全没有交集
                if (intervals.get(i).start > result_end) {
                    //把前一个放进去
                    result.add(new Interval(result_start, result_end));
                    //把这两个值赋予初值，开始下一轮循环
                    result_start = intervals.get(i).start;
                    result_end = intervals.get(i).end;
                } else {
                    //说明这两个的区间是有交集的
                    result_end = Math.max(intervals.get(i).end, result_end);
                }
            }
        }
        //记得把最后的一个区间放进去
        result.add(new Interval(result_start, result_end));
        return result;
    }

    //搞个比较器类，start小的排前面
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            if (o1.start < o2.start) {
                return -1;
            } else if (o1.start > o2.start) {
                return 1;
            } else return 0;


            //return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
        list.add(new Interval(2, 4));
        list.add(new Interval(2, 5));
        list.add(new Interval(2, 3));
        Solution solution = new Solution();
        System.out.println(solution.merge(list).toString());


    }
}

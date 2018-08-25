package com.hard.insertInterval;

import com.structure.Interval.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //开辟新的list用来存放处理之后的结果
        List<Interval> list = new ArrayList<>();
        //如果是空的就直接把新的区间返回去即可
        if (intervals.isEmpty()) {
            list.add(newInterval);
            return list;
        }
        for (int i = 0; i < intervals.size(); i++) {
            if (!judgeOverlap(newInterval, intervals.get(i))) {
                //如果没有交集，直接放进去就行
                list.add(intervals.get(i));
            } else {
                //有交集则扩展这个交集
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }
        }
        //最后把融合成的大区间放进去
        list.add(newInterval);
        //排个序
        Collections.sort(list, new IntervalComparator());
        return list;
    }

    /**
     * 判断两个区间是否有重合
     *
     * @param i1 区间1
     * @param i2 区间2
     * @return true=有重合
     */
    public boolean judgeOverlap(Interval i1, Interval i2) {
        if (i1.start <= i2.start && i1.end >= i2.end) {
            return true;
        }
        if (i1.start <= i2.start && i1.end <= i2.end && i1.end >= i2.start) {
            //这里注意有三个判断
            return true;
        }
        if (i1.start >= i2.start && i1.end >= i2.end && i1.start <= i2.end) {
            //这里注意有三个判断
            return true;
        }
        if (i1.start >= i2.start && i1.end <= i2.end) {
            return true;
        }
        return false;
    }

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
        Solution solution = new Solution();
        List<Interval> intervals = new ArrayList<>();
        Interval newIntervals = new Interval(0, 0);
        intervals.add(new Interval(1, 5));
        //intervals.add(new Interval(6, 9));
        System.out.println(solution.insert(intervals, newIntervals));
    }


}

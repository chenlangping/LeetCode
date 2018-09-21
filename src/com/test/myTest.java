package com.test;

import com.medium.triangle.Solution;

import java.util.ArrayList;
import java.util.List;


public class myTest {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> triangle = new ArrayList<>();
        List list1= new ArrayList();
        list1.add(2);

        List list2= new ArrayList();
        list2.add(3);
        list2.add(4);

        List list3= new ArrayList();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List list4= new ArrayList();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        triangle.add(list1);
        triangle.add(list2);
        //triangle.add(list3);
        //triangle.add(list4);

        System.out.println(solution.minimumTotal(triangle));
    }


}

package com.util;

public class myArray {

    /**
     * 交换数组中的两个元素，并没有做下标检查
     * @param array 目标数组
     * @param i 下标1
     * @param j 下标2
     */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

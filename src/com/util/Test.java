package com.util;

public class Test {
    public static void main(String[] args) {
        myArrayList list = new myArrayList(3);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(2,"5");
        list.print();
    }
}

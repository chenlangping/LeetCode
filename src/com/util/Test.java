package com.util;

public class Test {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        //list.add(4,"555");
        list.set(4,"5");
        list.print();

    }
}

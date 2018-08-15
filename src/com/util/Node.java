package com.util;

public class Node {
    private Node previous;
    private Object object;
    private Node next;

    public Node(Object object) {
        this.object = object;
    }

    public Node() {

    }

    public Node getPrevious() {
        return previous;
    }

    public Object getObject() {
        return object;
    }

    public Node getNext() {
        return next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}



package com.util;

public class myLinkedList {
    private Node first;
    private Node last;
    private int size;

    /**
     * 新增一个节点
     *
     * @param object 新增节点所带的对象
     */
    public void add(Object object) {
        Node node = new Node();
        if (null == first) {
            //如果是第一个节点
            node.setPrevious(null);
            node.setObject(object);
            node.setNext(null);
            first = node;
            last = node;
        } else {
            node.setPrevious(last);
            node.setObject(object);
            node.setNext(null);
            last.setNext(node);
            last = node;
        }
        size++;
    }

    /**
     * 在指定位置插入
     *
     * @param index  数组下标，最大可等于当前链表长度
     * @param object 插入的对象
     */
    public void add(int index, Object object) {
        if (index < 0 || size < index) {
            System.out.println("下标错误！");
        }
        if (index == size) {
            Node newNode = new Node(object);
            last.setNext(newNode);
            newNode.setPrevious(last);
            last = newNode;
            size++;
            return;
        }

        Node node = getNode(index);
        Node newNode = new Node(object);
        if (node.getPrevious() == null) {
            //此时Node是第一个，也就是first
            first.setPrevious(newNode);
            newNode.setNext(first);
            first = newNode;
            first.setPrevious(null);
            size++;
            return;
        }
        node.getPrevious().setNext(newNode);
        newNode.setNext(node);
        size++;
    }

    /**
     * 删除指定下标的节点
     *
     * @param index 下标
     * @return 成功删除返回true
     */
    public boolean remove(int index) {
        checkRange(index);
        Node node = first;
        int count = 0;
        if (node == null) {
            return false;
        } else {
            if (index == 0) {
                first = first.getNext();
                size--;
                return true;
            }
            while (node.getNext() != null) {
                count++;
                node = node.getNext();
                if (count == index) {
                    //删除操作
                    node.getPrevious().setNext(node.getNext());
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 删除链表中第一个指定的对象
     *
     * @param object
     * @return true=删除成功；false=删除失败
     */
    public boolean remove(Object object) {
        Node node = new Node();
        node = first;
        while (node.getNext() != null) {
            if (node.getObject().equals(object)) {
                //进行删除操作
                node.getPrevious().setNext(node.getNext());
                size--;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    /**
     * 将指定下标的元素修改成指定的对象
     *
     * @param index  下标
     * @param object 对象
     */
    public void set(int index, Object object) {
        checkRange(index);
        Node node = getNode(index);
        node.setObject(object);
    }

    /**
     * 返回指定位置的对象
     *
     * @param index 下标，从0开始
     * @return 对应位置的元素
     */
    public Object get(int index) {
        checkRange(index);
        int count = 0;
        if (first == null) {
            return null;
        } else {
            Node temp = first;
            if (index == 0) {
                return temp.getObject();
            }
            while (temp.getNext() != null) {
                temp = temp.getNext();
                count++;
                if (index == count) {
                    return temp.getObject();
                }
            }
            return null;
        }
    }

    /**
     * 返回指定位置处的节点
     *
     * @param index 下标
     * @return 如果存在就返回节点，否则返回空
     */
    public Node getNode(int index) {
        checkRange(index);
        int count = 0;
        Node node = first;
        if (index == 0) {
            return first;
        } else {
            while (node.getNext() != null) {
                node = node.getNext();
                count++;
                if (index == count) {
                    return node;
                }
            }

            return null;
        }
    }

    /**
     * 打印整个链表
     */
    public void print() {
        Node node = first;
        while (node != null) {
            System.out.println(node.getObject());
            node = node.getNext();
        }
    }

    /**
     * 返回当前链表长度
     *
     * @return 当前链表长度
     */
    public int getSize() {
        return size;
    }

    /**
     * 确认传入的下标是否合法
     *
     * @param index
     */
    private void checkRange(int index) {
        if (index < 0 || size <= index) {
            System.out.println("下标错误");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}



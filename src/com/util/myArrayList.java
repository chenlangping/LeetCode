package com.util;

/**
 * 自己写的一个数组的Arraylist实现
 */

public class myArrayList {
    private Object elementData[];
    private int size;

    /**
     * 无参构造器
     */
    public myArrayList() {
        this(10);
    }

    /**
     * 带参构造器
     *
     * @param initialCapacity 数组初始大小
     */
    public myArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            System.out.println("长度不可小于0");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            elementData = new Object[initialCapacity];
        }
    }

    /**
     * @param obj 在数组最后面增加一个元素
     */
    public void add(Object obj) {
        //可能会超过上限，先确保空间足够
        ensureCapacity();
        elementData[size] = obj;
        size++;
    }

    /**
     * 在数组指定位置加一个元素，之后的元素向后移动一位
     *
     * @param index 插入的位置，以0开始
     * @param obj
     */
    public void add(int index, Object obj) {
        //可能会超过上限，先确保空间足够
        ensureCapacity();
        //这里不可以使用checkRange()
        if (index < 0 || index > size) {
            System.out.println("下标错误");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = obj;
        size++;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 数组下标
     */
    public void remove(int index) {
        checkRange(index);
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size - 1] = null;
        size--;

    }

    /**
     * 删除相同的元素 如果没有就不删除
     *
     * @param obj
     */
    public void remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(obj)) {
                remove(i);
            }
        }

    }

    /**
     * 将指定位置的元素设置成指定的对象
     *
     * @param index 数组下标
     * @param obj   要设置的对象
     */
    public void set(int index, Object obj) {
        checkRange(index);
        elementData[index] = obj;
    }

    /**
     * 获取指定位置的元素
     *
     * @param index 数组下标
     * @return 指定位置的元素
     */
    public Object get(int index) {
        checkRange(index);
        return elementData[index];
    }

    /**
     * 确保数组的下标是否合法
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

    /**
     * 确保数组长度是否足够，不够则扩展数组
     */
    private void ensureCapacity() {
        if (size > elementData.length - 1) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    /**
     * 打印整个list
     */
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(get(i));
        }
    }

    /**
     * 获取当前的数组实际大小
     *
     * @return 返回数组实际大小
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 返回数组是否是空
     *
     * @return 数组长度为0返回true
     */
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

}

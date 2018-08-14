package com.util;



public class myArrayList {
    private Object elementData[];
    private int size;

    public myArrayList(){
        this(10);
    }

    public myArrayList(int initialCapacity){
        if(initialCapacity < 0){
            System.out.println("长度不可小于0");
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            elementData = new Object[initialCapacity];
        }
    }

    public void add(Object obj){
        //可能会超过上限，先确保空间足够
        ensureCapacity();
        elementData[size] = obj;
        size++;
    }

    public void add(int index,Object obj){
        //可能会超过上限，先确保空间足够
        ensureCapacity();
        //这里不可以使用checkRange()
        if(index <0 || index>size){
            System.out.println("下标错误");
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = obj;
        size++;
    }

    public int getSize(){return this.size;}

    public boolean isEmpty(){return size==0?true:false;}

    public Object get(int index){
        checkRange(index);
        return elementData[index];
    }

    public void remove(int index){
        checkRange(index);
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[size-1]= null;
        size--;

    }

    public void remove(Object obj){
        for(int i = 0;i<size;i++){
            if(get(i).equals(obj)){
                remove(i);
            }
        }

    }

    public void checkRange(int index){
        if(index < 0 || size <= index){
            System.out.println("下标错误");
            try{
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void ensureCapacity(){
        if(size > elementData.length - 1){
            Object [] newArray = new Object[size*2 +1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
    }

    public void set(int index,Object obj){
        checkRange(index);
        elementData[index]=obj;
    }

    public void print(){
        for(int i = 0;i<size;i++){
            System.out.println(get(i));
        }
    }

}

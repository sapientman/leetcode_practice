package com.java.datastruct.array;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/8/14 14:20
 */
public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        this.data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取当前数据量
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

}

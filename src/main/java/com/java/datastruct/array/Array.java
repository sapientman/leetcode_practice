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

    /**
     * 向数组末尾添加元素
     */
    public void addLast(int e){
        // 判断添加的元素是否大于最大的店铺
        /*if (data.length == size) {
            throw new RuntimeException("数组越界");
        }
        data[size] = e;
        size++;*/
        add(size,e);
    }

    /**
     * 向数组头添加元素
     */
    public void addFirst(int e){
        add(0, e);
    }

    /**
     * 添加元素
     */
    public void add(int index, int e){
        if (data.length == size) {
            throw new RuntimeException("数据满了");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不对");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取元素
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不正常");
        }
        return data[index];
    }

    /**
     * 设置值
     * @param index
     * @param e
     */
    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不正常");
        }
        data[index] = e;
    }

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    public boolean contains(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(int e){
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数据，并且返回删除的该值
     * @param index
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引不正确");
        }
        int value = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return value;
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public int removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除第一个元素
     * @return
     */
    public int removeFirst(){
        return remove(0);
    }

    /**
     * 删除指定元素
     * @return
     */
    public void removeElement(int e){
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }


    public static void main(String[] args) {
        int num = 100000;
        Array array = new Array(num);
        long l = System.currentTimeMillis();
        // 添加元素
        /*for (int i = 0; i < num; i++) {
            array.addLast(i);
        }*/

        System.out.println(String.format("时间为:%dms", (System.currentTimeMillis()-l)));
    }
}

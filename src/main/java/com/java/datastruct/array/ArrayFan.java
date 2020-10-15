package com.java.datastruct.array;


import java.util.Arrays;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/8/14 14:20
 */
public class ArrayFan<E> {
    // 泛型的E是data数组的类型
    private E[] data;
    private int size;

    public ArrayFan(int capacity) {
        // 不支持直接new 一个泛型的E 比如：new E[] 需要写为 this.data = (E[]) new Object[capacity];
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayFan() {
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
    public void addLast(E e){
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
    public void addFirst(E e){
        add(0, e);
    }

    /**
     * 添加元素
     */
    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不对");
        }
        // 当数组满了，不抛异常了，需要进行扩容
        /*if (data.length == size) {
            throw new RuntimeException("数据满了");
        }*/
        // 2. 扩容数组
        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 扩容
     * @param newCapacity
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    /**
     * 获取元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不正常");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     * @return
     */
    public E getLast(){
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 设置值
     * @param index
     * @param e
     */
    public void set(int index, E e) {
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
    public boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
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
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数据，并且返回删除的该值
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引不正确");
        }
        E value = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        // 把数组中引用的外部的对象设置为null，就会释放该对象了
        data[size] = null;

        // 2. 重置容器大小，当当前的容积减少为原来的1/2时，就减少容量
        /*if (size == data.length / 4) {
            resize(data.length/2);
        }*/
        // 3. 优化队列动荡，重置容器大小，当当前的容积减少为原来的1/4时，就减少容量
        if (size == data.length / 4) {
            resize(data.length/2);
        }

        return value;
    }

    /**
     * 删除最后一个元素
     * @return
     */
    public E removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除指定元素
     * @return
     */
    public void removeElement(E e){
        int i = find(e);
        if (i != -1) {
            remove(i);
        }
    }

    @Override
    public java.lang.String toString() {
        return "ArrayFan{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Integer num = 10000000;
        ArrayFan<Integer> array = new ArrayFan<Integer>(num);
        long l = System.currentTimeMillis();
        // 添加元素
        for (int i = 0; i < num; i++) {
            array.addLast(i);
        }
//        array.addFirst(11);

        System.out.println(String.format("时间为:%dms", (System.currentTimeMillis()-l)));
//        System.out.println(array);
//        array.remove(1);
//        System.out.println(array);
    }
}

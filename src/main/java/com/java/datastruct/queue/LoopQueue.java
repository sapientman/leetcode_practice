package com.java.datastruct.queue;


/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 14:08
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    /** 队首的索引 */
    private int front;
    /** 队尾的索引 */
    private int tail;
    /** 队列大小 */
    private int size;

    public LoopQueue(int capacity) {
        // 因为我们要有效的减少一个元素
        this.data = (E[]) new Object[capacity+1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            // 扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity+1];
        for (int i = 0; i < size; i++) {
            // 将数组放到新的数组的话，就重新排列好
            newData[i] = data[i + front];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            // 缩容
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E front() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return data[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("loopQueue top");
        sbr.append("[");
        for (int i = front; i != tail; i = (i+1)%data.length) {
            sbr.append(data[i]);
            if ((i+1)%data.length != tail) {
                sbr.append(",");
            }
        }
        sbr.append("] button");
        return sbr.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<Integer>(10);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}

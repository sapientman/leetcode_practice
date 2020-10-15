package com.java.datastruct.queue;

import com.java.datastruct.array.ArrayFan;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 11:51
 */
public class ArrayQueue<E> implements Queue<E> {
    private ArrayFan<E> arrayFan;

    public ArrayQueue(int capacity) {
        this.arrayFan = new ArrayFan<E>(capacity);
    }

    public void enqueue(E e) {
        arrayFan.addLast(e);
    }

    public E dequeue() {
        return arrayFan.removeFirst();
    }

    public E front() {
        return arrayFan.getFirst();
    }

    public int getSize() {
        return arrayFan.getSize();
    }

    public boolean isEmpty() {
        return arrayFan.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("queue top");
        sbr.append("[");
        for (int i = 0; i < getSize(); i++) {
            sbr.append(arrayFan.get(i));
            if (i != getSize() - 1) {
                sbr.append(",");
            }
        }
        sbr.append("] button");
        return sbr.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(10);
        for (int i = 0; i < 5; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }
        arrayQueue.dequeue();
        System.out.println(arrayQueue);
    }
}

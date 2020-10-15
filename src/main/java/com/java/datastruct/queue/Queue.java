package com.java.datastruct.queue;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 11:45
 */
public interface Queue<E> {
    /**
     * 入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 队首元素
     * @return
     */
    E front();

    /**
     * 队列大小
     * @return
     */
    int getSize();

    /**
     * 队列是否是空
     * @return
     */
    boolean isEmpty();
}

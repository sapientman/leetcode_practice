package com.java.datastruct.stack;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 10:20
 */
public interface Stack<E> {
    /**
     * 放入元素
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     * @return
     */
    E peek();

    /**
     * 是否是空的
     * @return
     */
    boolean isEmpty();

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();
}

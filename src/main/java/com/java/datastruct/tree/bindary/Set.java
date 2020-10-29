package com.java.datastruct.tree.bindary;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/26 15:10
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    /**
     * 获取数据量
     * @return
     */
    int getSize();

    boolean isEmpty();
}

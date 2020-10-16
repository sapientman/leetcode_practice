package com.java.datastruct.list;

import com.java.datastruct.stack.Stack;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/16 15:22
 */
public class ListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public ListStack() {
        this.linkedList = new LinkedList<E>();
    }

    /**
     * 链表头是栈顶
     * @param e
     */
    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public int getSize() {
        return linkedList.getSize();
    }
}

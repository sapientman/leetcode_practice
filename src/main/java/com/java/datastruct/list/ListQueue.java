package com.java.datastruct.list;

import com.java.datastruct.queue.Queue;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/16 15:36
 */
public class ListQueue<E> implements Queue<E> {
    /**
     * 私有类的话，只能在内部使用
     */
    private class Node<E> {
        /**
         * 当前存储的值，这里设置为public的话，在外部类就可以直接访问了
         */
        public E e;
        /**
         * 下一个节点
         */
        public Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /** 头结点 */
    private Node<E> head;
    /** 尾结点 */
    private Node<E> tail;
    /** 大小 */
    private int size;

    public ListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * 入队操作
     * @param e
     */
    public void enqueue(E e) {
        if (tail == null) {
            // 尾结点元素
            tail = new Node<E>(e);
            head = tail;
        } else {
            tail.next = new Node<E>(e);
            tail = tail.next;
        }
        size++;
    }

    /**
     * 通过head结点和tail结点来处理入队和出队，这样维护了一个tail字段，时间复杂度就变成了O(1)
     * @return
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("数据为空");
        }
        Node<E> retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    public E front() {
        return null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("Queue: front ");
        Node<E> cur = head;
        while (cur != null) {
            sbr.append(cur.e).append("->");
            cur = cur.next;
        }
        sbr.append("NULL");
        return sbr.toString();
    }

    public static void main(String[] args) {

    }
}

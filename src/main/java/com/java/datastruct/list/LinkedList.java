package com.java.datastruct.list;


/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/16 10:36
 */
public class LinkedList<E> {

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

    /**
     * 虚拟头节点
     */
    private Node<E> dummyHead;
    /**
     * 链表大小
     */
    private int size;

    public LinkedList() {
        this.dummyHead = new Node<E>(null, null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表头添加新的元素e
     */
    public void addFirst(E e) {
        /*Node<E> node = new Node<E>(e);
        node.next = head;
        head = node;*/
        // 简化为
        /*head = new Node<E>(e, head);
        size++;*/
        add(0, e);
    }

    /**
     * 在链表中间添加元素,
     * 在链表头插入元素和其他位置的插入是有区别的，但是我们想要统一起来，我们可以设置一个虚拟头结点
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new RuntimeException("索引不合法");
        }
        // 找到之前的位置是前面一个节点的元素，就是虚拟头结点
        Node<E> prev = dummyHead;
        // 查找节点的上一个节点
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        /*Node<E> node = new Node<E>(e);
        node.next = prev.next;
        prev.next = node;*/
        // 简化
        prev.next = new Node<E>(e, prev.next);
        size++;
        // 1. 先创建链表节点
        // 2. 将要插入的链表的前一个元素的下一个节点
    }

    public void addLast(E e){
       add(size, e);
    }

    /**
     * 获得链表的第index个位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引不合法");
        }
        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引不合法");
        }

        Node<E> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除指定位置的元素
     * @param index
     */
    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new RuntimeException("索引不合法");
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<E> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            sbr.append(cur).append("->");
            cur = cur.next;
        }
        // 同理的for循环
        /*for (Node<E> cur = dummyHead.next; cur != null; cur = cur.next) {

        }*/
        sbr.append("NULL");
        return sbr.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        linkedList.add(2, 66);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}

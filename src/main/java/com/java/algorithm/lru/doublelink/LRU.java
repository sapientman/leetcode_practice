package com.java.algorithm.lru.doublelink;

import java.util.HashMap;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/8/11 17:07
 */
public class LRU<K,V> {
    /** 当前链表的大小 */
    private int currentSize;
    /** 总容量 */
    private int capcity;
    /** 所有的node节点 */
    private HashMap<K, Node> caches;
    /** 头节点 */
    private Node first;
    /** 尾节点 */
    private Node last;

    public LRU(int capcity) {
        currentSize = 0;
        this.capcity = capcity;
        caches = new HashMap<K, Node>();
    }

    /**
     * 添加元素
     */
    public void put(K key, V value){
        Node node = caches.get(key);
        // 是新元素
        if (node == null) {
            // 如果超过了元素的容量
            if (caches.size() >= capcity) {
                // 移除最后一个元素
                caches.remove(last.key);
                removeLast();
            }
            // 创建新节点
            node = new Node(key, value);
            caches.put(key, node);
            currentSize++;
        } else {
            // 已经存在的元素覆盖旧值
            node.value = value;
        }
        // 把元素移动到首部
        moveToHead(node);
    }

    /**
     * 获取元素
     * @param key
     * @return
     */
    public Object get(K key) {
        Node node = caches.get(key);
        if (node == null) {
            return null;
        }
        // 把访问的元素的节点移动到首部
        moveToHead(node);
        return node.value;
    }

    /**
     * 根据key移除节点
     */
    public Object remove(K key){
        Node node = caches.get(key);
        if (node != null) {
            // 判断是否是首节点
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.pre;
            }
        }
        return caches.remove(key);
    }

    /**
     * 移动元素到头节点
     * @param node
     */
    public void moveToHead(Node node){
        if (first == node) {
            return;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node == last) {
            last = last.pre;
        }
        if (first == null || last == null) {
            first = last = node;
            return;
        }
        node.next = first;
        first.pre = node;
        first = node;
        first.pre = null;
    }

    /**
     * 移除最后一个元素
     */
    public void removeLast(){
        if (last != null) {
            last = last.pre;
            if (last == null) {
                first = null;
            } else {
                last.next = null;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = first;
        while (node != null) {
            sb.append(String.format("%s:%s ", node.key, node.value));
            node = node.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<Integer, String>(5);
        lru.put(1, "a");
        lru.put(2, "b");
        lru.put(3, "c");
        lru.put(4,"d");
        lru.put(5,"e");
        System.out.println("原始链表为:"+lru.toString());

        lru.get(4);
        System.out.println("获取key为4的元素之后的链表:"+lru.toString());

        lru.put(6,"f");
        System.out.println("新添加一个key为6之后的链表:"+lru.toString());

        lru.remove(3);
        System.out.println("移除key=3的之后的链表:"+lru.toString());
    }
}

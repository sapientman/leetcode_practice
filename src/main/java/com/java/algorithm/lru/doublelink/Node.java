package com.java.algorithm.lru.doublelink;

/**
 * 定义双向链表的节点
 * @author 子荀
 * @version 1.0
 * @date 2020/8/11 16:44
 */
public class Node {
    /** 键 */
    Object key;
    /** 值 */
    Object value;
    /** 前置节点 */
    Node pre;
    /** 后置节点 */
    Node next;

    public Node(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}

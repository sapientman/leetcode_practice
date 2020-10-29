package com.java.datastruct.tree.bindary;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/26 14:54
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        /** 数据值 */
        public E e;
        /** 左子树 */
        public Node left;
        /** 右子树 */
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /** 根节点 */
    private Node root;
    /** 数据大小 */
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        add(root, e);
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node add(Node node, E e) {
        if (node == null) {
            return new Node(e);
        } else {
            if (e.compareTo(node.e) < 0) {
                node.left = add(node.left, e);
            } else if(e.compareTo(node.e) > 0){
                node.right = add(node.right, e);
            } else {
                // 当e等于node.e的时候，把值替换调
                node.e = e;
            }
            return node;
        }
    }

    public void remove(E e) {

    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        // 终止情况
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            // 递归调用左子树去查找
            return contains(node.left, e);
        } else {
            // 递归右子树去查找
            return contains(node.right, e);
        }
    }


}

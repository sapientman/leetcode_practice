package com.java.datastruct.tree.bindary;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/26 15:11
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST<E> bst;

    public BSTSet(){
        bst = new BST<E>();
    }

    public void add(E e) {
        bst.add(e);
    }


    public void remove(E e) {
        bst.remove(e);
    }

    public boolean contains(E e) {
        return bst.contains(e);
    }

    public int getSize() {
        return bst.size();
    }

    public boolean isEmpty() {
        return bst.isEmpty();
    }
}

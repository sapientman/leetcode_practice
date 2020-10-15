package com.java.datastruct.stack;

import com.java.datastruct.array.Array;
import com.java.datastruct.array.ArrayFan;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 10:13
 */
public class ArrayStack<E> implements Stack<E>{
    private ArrayFan<E> array;

    public ArrayStack(int capacity) {
        array = new ArrayFan<E>(capacity);
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.removeLast();
    }

    public E peek() {
        return array.getLast();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString(){
        StringBuilder sbr = new StringBuilder();
        sbr.append("Stack: ");
        sbr.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sbr.append(array.get(i));
            if (i != array.getSize() - 1) {
                sbr.append(",");
            }
        }
        sbr.append("]top");
        return sbr.toString();
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>(10);
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        arrayStack.pop();
        System.out.println(arrayStack);
    }
}

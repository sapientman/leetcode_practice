package com.java.datastruct.list;

import com.java.datastruct.stack.ArrayStack;
import com.java.datastruct.stack.Stack;

import java.util.Random;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/16 15:26
 */
public class TestMain {
    private static double testQueue(Stack<Integer> stack, int opCount){
        long startTime = System.nanoTime();

        // 入队
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;
        // arrayStack
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>(opCount);
        double time1 = testQueue(arrayStack, opCount);
        System.out.println("arrayStack:time:" + time1);
        // linkedStack
        ListStack<Integer> listStack = new ListStack<Integer>();
        double time2 = testQueue(listStack, opCount);
        System.out.println("arrayStack:time:" + time2);
    }
}

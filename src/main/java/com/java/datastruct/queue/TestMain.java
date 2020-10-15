package com.java.datastruct.queue;

import java.util.Random;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/15 15:15
 */
public class TestMain {

    private static double testQueue(Queue<Integer> queue, int opCount){
        long startTime = System.nanoTime();

        // 入队
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static void main(String[] args) {
        int opCount = 100000;

        // ArrayQueue
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<Integer>(opCount);
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("arrayqueue， time: "+ time1 + " s");
        // LoopQueue
        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>(opCount);
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("loopqueue， time: "+ time2 + " s");
    }
}

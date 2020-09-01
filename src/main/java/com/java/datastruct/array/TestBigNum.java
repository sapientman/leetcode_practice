package com.java.datastruct.array;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/9/1 09:46
 */
public class TestBigNum {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] nums = new int[7000000];
        for (int i = 0; i < 7000000; i++) {
            nums[i] = i;
        }
        System.out.println("执行时间为: " + (System.currentTimeMillis()-startTime)+ "ms");
    }
}

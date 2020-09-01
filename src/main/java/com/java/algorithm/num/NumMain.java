package com.java.algorithm.num;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/8/13 19:05
 */
public class NumMain {
    public static void main(String[] args) {
        int a = 5;
        String s = Integer.toBinaryString(a);
//        String s1 = Integer.toHexString(a);
        System.out.println(s);
//        System.out.println(s1);
        int b = -5;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(a & b);
    }
}

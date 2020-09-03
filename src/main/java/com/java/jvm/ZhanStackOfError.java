package com.java.jvm;

/**
 * -- 25416
 * 144k --> 1728
 * @author 子荀
 * @version 1.0
 * @date 2020/9/3 15:30
 */
public class ZhanStackOfError {
    private int num = 1;
    public void stack(){
        num++;
        this.stack();
    }

    public static void main(String[] args) throws Throwable {
        ZhanStackOfError zhanStackOfError = new ZhanStackOfError();
        try {
            zhanStackOfError.stack();
        } catch (Throwable e) {
            System.out.println("栈的大小:" + zhanStackOfError.num);
            throw e;
        }
    }
}

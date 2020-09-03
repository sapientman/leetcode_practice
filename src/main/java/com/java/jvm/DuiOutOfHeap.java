package com.java.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author 子荀
 * @version 1.0
 * @date 2020/9/3 14:59
 */
public class DuiOutOfHeap {
    public static List<String> list = new ArrayList<String>();
    public static void main(String[] args) {
        while (true) {
            list.add(UUID.randomUUID().toString());
        }
    }
}

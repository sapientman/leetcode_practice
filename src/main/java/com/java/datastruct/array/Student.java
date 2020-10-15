package com.java.datastruct.array;

/**
 * @author 子荀
 * @version 1.0
 * @date 2020/10/14 14:12
 */
public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        ArrayFan<Student> arrayFan = new ArrayFan<Student>(10);
        arrayFan.addLast(new Student("alice", 10));
        arrayFan.addLast(new Student("tom", 20));
        arrayFan.addLast(new Student("cati", 11));
        System.out.println(arrayFan);
    }
}

package com.chris.some.code.y2019.m01.d22;

import com.chris.some.code.y2018.m12.d28.People;

/**
 * java中只有按值调用
 *
 * @author chris
 */
public class CallByValueTest {

    private static final int X = 10;
    private static People people = null;
    private static People teacher = null;
    private static People student = null;

    public static void main(String[] args) {
        System.out.println("调用前x的值:" + X);
        updateValue(X);
        System.out.println("调用后x的值:" + X);

        people = new People("张三", 26);
        System.out.println("调用前people的值：" + people.toString());
        updatePeople(people);
        System.out.println("调用后people的值：" + people.toString());

        teacher = new People("teacher", 26);
        student = new People("student", 16);
        System.out.println("调用前teacher的值：" + teacher.toString());
        System.out.println("调用前student的值：" + student.toString());
        change(teacher, student);
        System.out.println("调用后teacher的值：" + teacher.toString());
        System.out.println("调用后student的值：" + student.toString());
    }

    public static void updateValue(int value) {
        value *= 3;
        System.out.println(value);
    }

    public static void updatePeople(People people) {
        people.setName("李四");
        people.setAge(18);
        System.out.println(people);
    }

    public static void change(People teacher, People student) {
        People people = teacher;
        teacher = student;
        student = people;
    }
}

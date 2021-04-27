package com.chris.some.code.y2019.m01.d22;

import com.chris.some.code.y2018.m12.d28.People;

/**
 * 1、不管 try，finally 都会执行；
 * 2、在 try 中return，在 finally 执行前会把结果保存起来，即使在 finally 中有修改也以 try 中保存的值为准，但如果是引用类型，修改的属性会以 finally 修改后的为准；
 * 3、如果 try/finally 都有 return，直接返回 finally 中的 return。
 *
 * @author Chris
 */
public class TestTryCatch {
    public static void main(String[] args) {
        //1
        System.out.println(test1());
        //0
        System.out.println(test2());
        //Jack 18
        System.out.println(test3());
        //Tom 19
        System.out.println(test4());
    }

    private static int test1() {
        int i = 1;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 0;
        }
        return i;
    }

    private static int test2() {
        int i = 1;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            i = 0;
            return i;
        }
    }

    private static People test3() {
        People people = new People("Jack", 18);
        try {
            return people;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            people = new People("Tom", 20);
        }
        return null;
    }

    private static People test4() {
        People people = new People("Jack", 19);
        try {
            return people;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            people.setName("Tom");
        }
        return null;
    }
}

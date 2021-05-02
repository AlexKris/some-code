package com.chris.some.code.y2019.m06.d03.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        filterSex();
        filterSexAndAge();
        getNameList();
        flatMapString();
        reduceTest();
        toListTest();
        toSetTest();
        toMapTest();
        toTreeSetTest();
        toGroupTest();
        toJoiningTest();
        reduce();
    }

    /**
     * filter
     * 过滤男性
     */
    private static void filterSex() {
        List<PersonModel> data = Data.getData();
        List<PersonModel> temp = new ArrayList<>();

        // old
        for (PersonModel person :
                data) {
            if ("男".equals(person.getSex())) {
                temp.add(person);
            }
        }
        System.out.println("filterSex.temp:" + temp);

        // new
        List<PersonModel> collect = data.
                stream().
                filter(person -> "男".equals(person.getSex())).
                collect(Collectors.toList());
        System.out.println("filterSex.collect:" + collect);
        List<String> nameList = new ArrayList<>();
        collect.forEach(personModel -> nameList.add(personModel.getName()));
        System.out.println("filterSex.nameList" + nameList);
    }

    /**
     * filter
     * 过滤男性 并且小于20岁
     */
    private static void filterSexAndAge() {
        List<PersonModel> data = Data.getData();
        List<PersonModel> temp = new ArrayList<>();

        // old
        for (PersonModel person :
                data) {
            if ("男".equals(person.getSex()) && person.getAge() < 20) {
                temp.add(person);
            }
        }
        System.out.println("filterSexAndAge.temp:" + temp);

        // new
        List<PersonModel> collect = data.
                stream().
                filter(person -> "男".equals(person.getSex()) && person.getAge() < 20).
                collect(Collectors.toList());
        System.out.println("filterSexAndAge.collect:" + collect);
    }

    /**
     * map
     * 取出姓名
     */
    private static void getNameList() {
        List<PersonModel> data = Data.getData();

        // old
        List<String> list = new ArrayList<>();
        for (PersonModel person :
                data) {
            list.add(person.getName());
        }
        System.out.println("getNameList.list:" + list);

        // new 1
        List<String> collect1 = data.stream().map(person -> person.getName()).collect(Collectors.toList());
        System.out.println("getNameList.collect1:" + collect1);

        // new 2
        List<String> collect2 = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        System.out.println("getNameList.collect2:" + collect2);

        // new 3
        List<String> collect3 = data.stream().map(person -> {
            System.out.println("getNameList.collect3.person.getName:" + person.getName());
            return person.getName();
        }).collect(Collectors.toList());
    }

    private static void flatMapString() {
        List<PersonModel> data = Data.getData();
        // 返回类型不一样
        List<String> collect1 = data
                .stream()
                .flatMap(person -> Arrays.stream(person.getName().split(" ")))
                .collect(Collectors.toList());
        System.out.println("flatMapString.collect1:" + collect1);

        List<Stream<String>> collect2 = data
                .stream()
                .map(person -> Arrays.stream(person.getName().split(" ")))
                .collect(Collectors.toList());
        System.out.println("flatMapString.collect2:" + collect2);

        List<String> collect3 = data
                .stream()
                .map(person -> person.getName().split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println("flatMapString.collect3:" + collect3);

        List<String> collect4 = data
                .stream()
                .map(person -> person.getName().split(" "))
                .flatMap(str -> Arrays.asList(str).stream())
                .collect(Collectors.toList());
        System.out.println("flatMapString.collect4:" + collect4);
    }

    /**
     * reduce
     * 类似递归
     */
    private static void reduceTest() {
        // 累加，初始化值是 10
        Integer reduce1 = Stream.of(1, 2, 3, 4).reduce(10, (count, item) -> {
            System.out.println("reduceTest.reduce1.count:" + count);
            System.out.println("reduceTest.reduce1.item:" + item);
            return count + item;
        });
        System.out.println("reduceTest.reduce1:" + reduce1);

        Integer reduce2 = Stream.of(1, 2, 3, 4).reduce(0, (x, y) -> x + y);
        System.out.println("reduceTest.reduce2:" + reduce2);

        String reduce3 = Stream.of("1", "2", "3").reduce("0", (x, y) -> (x + "," + y));
        System.out.println("reduceTest.reduce3:" + reduce3);
    }

    /**
     * collect
     * 在流中生成列表、map等常用数据结构
     * 1.toList
     */
    private static void toListTest() {
        List<PersonModel> data = Data.getData();
        List<String> collect = data.stream().map(PersonModel::getName).collect(Collectors.toList());
        System.out.println("toListTest.collect:" + collect);
    }

    /**
     * collect
     * 2.toSet
     */
    private static void toSetTest() {
        List<PersonModel> data = Data.getData();
        Set<String> collect = data.stream().map(PersonModel::getName).collect(Collectors.toSet());
        System.out.println("toSetTest.collect:" + collect);
    }

    /**
     * collect
     * 3.toMap
     */
    private static void toMapTest() {
        List<PersonModel> data = Data.getData();
        Map<String, Integer> collect = data.stream().collect(
                Collectors.toMap(PersonModel::getName, PersonModel::getAge)
        );
        System.out.println("toMapTest.collect:" + collect);
        data.stream().collect(Collectors.toMap(PersonModel::getName, value -> value + "1"));
    }

    /**
     * collect
     * 指定类型
     * 有错
     */
    private static void toTreeSetTest() {
        List<PersonModel> data = Data.getData();
        TreeSet<PersonModel> collect = data.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("toTreeSetTest.collect:" + collect);
    }

    /**
     * collect
     * 分组
     */
    private static void toGroupTest() {
        List<PersonModel> data = Data.getData();
        Map<Boolean, List<PersonModel>> collect = data.stream().collect(Collectors.groupingBy(per -> "男".equals(per.getSex())));
        System.out.println("toGroupTest.collect:" + collect);
    }

    /**
     * collect
     * 分隔
     */
    private static void toJoiningTest() {
        List<PersonModel> data = Data.getData();
        String collect = data.stream().map(PersonModel::getName).collect(Collectors.joining(",", "{", "}"));
        System.out.println("toJoiningTest.collect:" + collect);
    }

    /**
     * collect
     * 自定义
     */
    private static void reduce() {
        List<String> collect = Stream.of("1", "2", "3").map(Arrays::asList).reduce(new ArrayList<String>(), (y, z) -> {
            y.addAll(z);
            return y;
        });
        System.out.println("reduce.collect:" + collect);
    }
}

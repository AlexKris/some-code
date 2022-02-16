package com.chris.some.code.study.geektime.datastructureandalgorithm.datastructure.linked;

/**
 * 单链表
 *
 * @author grt
 */
public class OneWayLinked<E> {

    int size;
    OneWayNode<E> first;

    private static class OneWayNode<E> {
        E item;
        OneWayNode<E> next;

        public OneWayNode(E element, OneWayNode<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}

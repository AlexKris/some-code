package com.chris.some.code.study.geektime.datastructureandalgorithm.datastructure.linked;

/**
 * 单链表
 *
 * @author grt
 */
public class TwoWayLinked<E> {

    int size;
    TwoWayNode<E> first;
    TwoWayNode<E> last;

    private static class TwoWayNode<E> {
        E item;
        TwoWayLinked<E> next;
        TwoWayLinked<E> prev;

        public TwoWayNode(E element, TwoWayLinked<E> next, TwoWayLinked<E> prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}

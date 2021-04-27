package com.chris.some.code.y2019.m01.d22;

import java.util.Iterator;

/**
 * 集合实现类
 *
 * @param <E>
 * @author Alex
 */
public class MyList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * 集合大小
     */
    private int size;
    /**
     * 使用泛型类型数据存储
     */
    private E[] items;

    /**
     * 初始化
     */
    public MyList() {
        clear();
    }


    public void clear() {
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    /**
     * 返回size
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 释放空间
     */
    public void trimToSize() {
        ensureCapacity(size());
    }

    public E get(int idx) {
        if (idx < 0 || idx > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[idx];
    }

    public E set(int idx, E newVal) {
        if (idx < 0 || idx >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldVal = items[idx];
        items[idx] = newVal;
        return oldVal;
    }

    /**
     * 设置集合容量
     *
     * @param newCapacity
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity < size()) {
            return;
        }
        E[] oldArray = items;
        items = (E[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            items[i] = oldArray[i];
        }
    }

    public boolean add(E x) {
        add(size(), x);
        return true;
    }

    /**
     * 指定位置添加变量
     *
     * @param idx
     * @param x
     */
    public void add(int idx, E x) {
        if (items.length == size()) {
            ensureCapacity(size() * 2 - 1);
        }
        //将idx位置后面的对象后移
        for (int i = size; i > idx; i--) {
            items[i] = items[i - 1];
        }
        items[idx] = x;
        size++;
    }

    /**
     * 移除指定位置对象
     *
     * @param idx
     * @return
     */
    public E remove(int idx) {
        E removedItem = items[idx];
        //将idx位置后面的对象前移
        for (int i = idx; i < size() - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return removedItem;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator();
    }

    /**
     * 实现Iterator接口的内部类
     */
    private class MyListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public E next() {
            return items[current++];
        }

        @Override
        public void remove() {
            MyList.this.remove(--current);
        }
    }
}

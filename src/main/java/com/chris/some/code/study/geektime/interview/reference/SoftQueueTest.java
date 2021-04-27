package com.chris.some.code.study.geektime.interview.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用队列测试
 * <p>
 * -Xms10m -Xmx10m
 * <p>
 * 当这个SoftReference所软引用的HeapObject被垃圾收集器回收的同时，SoftReference对象被列入ReferenceQueue。也就是说，ReferenceQueue中保存的对象是Reference对象，而且是已经失去了它所软引用的对象（HeapObject ）的Reference对象
 *
 * @author chris
 */
public class SoftQueueTest {

    static class HeapObject {
        byte[] bytes = new byte[1024 * 1024];
    }

    public static void main(String[] args) {
        ReferenceQueue<HeapObject> referenceQueue = new ReferenceQueue<>();
        SoftReference<HeapObject> softReference = new SoftReference<>(new HeapObject(), referenceQueue);

        List<HeapObject> list = new ArrayList<>();

        while (true) {
            if (softReference.get() != null) {
                list.add(new HeapObject());
                System.out.println("list.add");
            } else {
                System.out.println("软引用已被回收");
                break;
            }
            System.gc();
        }

        Reference<? extends HeapObject> pollRef = referenceQueue.poll();
        while (pollRef != null) {
            System.out.println(pollRef);
            System.out.println(pollRef.get());
            pollRef = referenceQueue.poll();
        }
    }
}

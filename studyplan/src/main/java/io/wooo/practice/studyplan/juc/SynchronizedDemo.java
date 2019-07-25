package io.wooo.practice.studyplan.juc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 主要用于对比：
 * 修饰实例方法、修饰静态方法、修饰代码块的区别。
 *
 * @author wushuaiping
 * @date 2019/7/17 16:45
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
//        final TestPrint print1 = new TestPrint();
//        final TestPrint print2 = new TestPrint();
//        new Thread(() -> print1.printOne(), "Thread1").start();
//        new Thread(() -> print2.printTwo(), "Thread2").start();

//        final List<Integer> initList = Arrays.asList(1, 2, 3);
//
//        List<Integer> list = new CopyOnWriteArrayList(initList);
//
//        new Thread(() -> {
//            list.forEach(i -> {
//                list.add(i + 1);
//            });
//        }).start();
//
//        new Thread(() -> {
//            list.forEach(i -> {
//                list.remove(i);
//            });
//        }).start();

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.removeIf((q) -> q.equals(1));
        final Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        AtomicReference<Thread> cas = new AtomicReference<Thread>();
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.add(1);
        // 获取队列的head 数据
//        final Integer headElement = queue.element();
//        queue.poll();
//        final Integer headElement = queue.element();
//        System.out.println(headElement);
    }
}

class TestPrint {

    /**
     * 让线程1进来之前先sleep 1秒钟
     */
    public static synchronized void printOne() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("One");
    }


    public static synchronized void printTwo() {
        System.out.println("Two");
    }
}

//class TestThread
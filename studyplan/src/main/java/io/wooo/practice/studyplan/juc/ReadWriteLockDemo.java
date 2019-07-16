package io.wooo.practice.studyplan.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *  读写锁，用于写场景少，读场景多。如一个线程写，多个线程读的情况。
 *  在写的时候会锁住，当写操作完成以后，共享变量才能被读到。
 * Created by wushuaiping on 2019/7/16
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        CustomReadWrite customReadWrite = new CustomReadWrite();
        // 一个线程写
        new Thread(() -> customReadWrite.setNumber((int) (Math.random() * 101)), "Write Thread").start();
        // 250个线程读
        for (int i = 0; i < 250; i++) {
            new Thread(customReadWrite::getNumber, "Read Thread-" + i).start();
        }
    }

}

class CustomReadWrite{

    private volatile int number = 0;

    private volatile ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public int getNumber() {
        System.out.println(Thread.currentThread().getName() + " waiting");
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get number :" + number);
            return number;
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void setNumber(int number) {
        readWriteLock.writeLock().lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " Write number : " + number);
            this.number = number;
        } catch (InterruptedException e) {

        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
}

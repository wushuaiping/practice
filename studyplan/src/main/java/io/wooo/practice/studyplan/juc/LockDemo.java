package io.wooo.practice.studyplan.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wushuaiping on 2019/7/11
 */
public class LockDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(100);
        new Thread(ticket, "1号窗口").start();
        new Thread(ticket, "2号窗口").start();
        new Thread(ticket, "3号窗口").start();
    }
}

class Ticket implements Runnable{

    private int ticket;

    private Lock lock = new ReentrantLock();

    Ticket(int ticket){this.ticket = ticket;}

    @Override
    public void run() {
        try {
            lock.lock();
            while (true){
                if (ticket > 0){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ": 卖出一张票，余：" + --ticket + "张票");
                }else {
                    break;
                }
            }
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
}

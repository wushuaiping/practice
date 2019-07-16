package io.wooo.practice.studyplan.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  开启3个线程，线程name分别为A/B/C，每个线程name打印10次。必须按顺序显示。
 * Created by wushuaiping on 2019/7/15
 */
public class ConditionDemo {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> print.loopA(1), "A").start();
        new Thread(() -> print.loopB(5), "B").start();
        new Thread(() -> print.loopC(30), "C").start();
    }
}

class Print{

    private int currentThreadNumber = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int printCount){
        lock.lock();
        try {
            // 不是1号线程不打印
            if (currentThreadNumber != 1){
                condition1.await();
            }

            for (int i = 1; i <= printCount; i++){
                System.out.println(Thread.currentThread().getName() + "线程打印第" + i + "次，总共需要打印" + printCount + "次");
            }

            System.out.println("------------------------------------------");

            // 唤醒2号线程
            currentThreadNumber = 2;
            condition2.signal();
        } catch (InterruptedException e) {

        }finally {
            lock.unlock();
        }
    }

    public void loopB(int printCount){
        lock.lock();
        try {
            // 不是1号线程不打印
            if (currentThreadNumber != 2){
                condition2.await();
            }

            for (int i = 1; i <= printCount; i++){
                System.out.println(Thread.currentThread().getName() + "线程打印第" + i + "次，总共需要打印" + printCount + "次");
            }

            System.out.println("------------------------------------------");

            // 唤醒2号线程
            currentThreadNumber = 3;
            condition3.signal();
        } catch (InterruptedException e) {

        }finally {
            lock.unlock();
        }
    }

    public void loopC(int printCount){
        lock.lock();
        try {
            // 不是1号线程不打印
            if (currentThreadNumber != 3){
                condition3.await();
            }

            for (int i = 1; i <= printCount; i++){
                System.out.println(Thread.currentThread().getName() + "线程打印第" + i + "次，总共需要打印" + printCount + "次");
            }

            System.out.println("------------------------------------------");

            // 唤醒2号线程
            currentThreadNumber = 3;
            condition1.signal();
        } catch (InterruptedException e) {

        }finally {
            lock.unlock();
        }
    }
}




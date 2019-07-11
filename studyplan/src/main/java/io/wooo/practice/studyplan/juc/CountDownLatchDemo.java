package io.wooo.practice.studyplan.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wushuaiping on 2019/7/11
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        TreadDemo treadDemo = new TreadDemo(cdl);
        long startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            new Thread(treadDemo).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }

        long endTime = System.nanoTime();
        System.out.println("耗费时间为：" + (endTime - startTime));
    }
}

class TreadDemo implements Runnable {
    CountDownLatch cdl;
    public TreadDemo(CountDownLatch cdl){
        this.cdl = cdl;
    }
    public void run() {
     try {
         for (int i = 0; i < 100000; i++) {
             if (i % 2 == 0){
                 System.out.println(i);
             }
         }
     }finally {
         cdl.countDown();
     }
    }

}
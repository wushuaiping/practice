package io.wooo.practice.studyplan.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 分别使用10个线程并行计算任务，
 * Created by wushuaiping on 2019/7/11
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(2);
        TreadDemo treadDemo = new TreadDemo(cdl);
        long startTime = System.nanoTime();
        for (int i = 0; i < 2; i++) {
            new Thread(treadDemo).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println("ERROR");
        }

        long endTime = System.nanoTime();
        System.out.println("耗费时间为：" + (endTime - startTime));
    }

    static class TreadDemo implements Runnable {

        private CountDownLatch cdl;

        TreadDemo(CountDownLatch cdl) {
            this.cdl = cdl;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                cdl.countDown();
            }
        }

    }
}
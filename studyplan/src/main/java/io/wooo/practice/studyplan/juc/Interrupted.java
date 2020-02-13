package io.wooo.practice.studyplan.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author wushuaiping
 * @date 2019/9/10 14:43
 */
public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        final Thread sleepThread = new Thread(new SleepRunner(), "SleepRunnerThread");
        sleepThread.setDaemon(true);
        final Thread busyThread = new Thread(new BusyRunner(), "BusyRunnerThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        // 主线程稍微睡眠一下，让sleepThread和busyThread充分运行
        TimeUnit.SECONDS.sleep(5);
        // 尝试中断
        sleepThread.interrupt();
        busyThread.interrupt();
        System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
        System.out.println("busyThread interrupted is " + busyThread.isInterrupted());
        SleepUtils.second(2);
    }

    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }

    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){}
        }
    }
}

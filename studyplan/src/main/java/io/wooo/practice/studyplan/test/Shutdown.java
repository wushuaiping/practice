package io.wooo.practice.studyplan.test;

import java.util.concurrent.TimeUnit;

/**
 * @author wushuaiping
 * @date 2019/9/11 10:47
 */
public class Shutdown {

    public static void main(String[] args) throws InterruptedException {
        Thread countThread = new Thread(new Runner(), "CountThread1");
        countThread.start();
        // 睡眠1秒
        TimeUnit.SECONDS.sleep(1);
        // 主线程控制CountThread1中断
        countThread.interrupt();
        final Runner runner = new Runner();
        countThread = new Thread(runner, "CountThread2");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        // 使用Runner的自定义方法cancel来控制CountThread2中断
        runner.cancel();
    }

    /**
     * 模拟线程中断，主要根据boolean值on来控制线程的中断。
     * 推荐使用该方式
     */
    static class Runner implements Runnable{
        private long i;
        // 中断操作的标志位
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("count i = " + i);
        }
        public void cancel(){
            on = false;
        }
    }
}

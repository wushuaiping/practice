package io.wooo.practice.studyplan.test;

/**
 * 守护线程，当main线程执行完毕后，daemon线程会随之关闭。
 *
 * @author wushuaiping
 * @date 2019/9/10 14:14
 */
public class Daemon {

    public static void main(String[] args) {
        final Thread thread = new Thread(new DaemonRunner(), "DaemonRunnerThread");
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName() + "Thread run is over.");
    }

    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            } finally {
                // 守护线程的finally没有执行完。因为main线程已经执行完毕。
                System.out.println(Thread.currentThread().getName() + " finally run.");
            }
        }
    }
}
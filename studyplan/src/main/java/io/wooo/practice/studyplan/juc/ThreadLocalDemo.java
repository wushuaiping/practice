package io.wooo.practice.studyplan.juc;

/**
 * @author wushuaiping
 * @date 2019/8/5 11:37
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        /**
         * ThreadLocal，每个线程可拥有单独的变量副本，互不影响其他线程所保存的值。
         */
        Thread.currentThread().setName("Main thread");
        threadLocal.set(Thread.currentThread().getName());
        new Thread(new Thread1(), "thread-1").start();
        new Thread(new Thread1(), "thread-2").start();
        System.out.println(threadLocal.get());

        /**
         * InheritableThreadLocal，父线程设置的值，子线程可可以访问。如果子线程单独设置了值，则当前子线程的值为子线程设置的值。而不是父线程设置的值。
         * ThreadLocal保存的值只与当前线程有关。
         */
        inheritableThreadLocal.set("inheritableThreadLocal Main thread value");
        new Thread(new Thread2(), "inheritableThreadLocal child thread-1").start();
        new Thread(new Thread2(), "inheritableThreadLocal child thread-2").start();
        System.out.println(inheritableThreadLocal.get());
    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        }
    }

    private static class Thread2 implements Runnable{
        @Override
        public void run() {
            inheritableThreadLocal.set(Thread.currentThread().getName());
            System.out.println(inheritableThreadLocal.get());
        }
    }

}

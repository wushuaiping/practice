package io.wooo.practice.studyplan.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 *  线程池调度demo
 * Created by wushuaiping on 2019/7/18
 */
public class TestScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5; i++) {
            // 第一个参数为 Callable或Runnable，第二个参数当前线程延迟多久执行，第三个参数为延迟时间的时间单位。
            ScheduledFuture<Integer> schedule = pool.schedule(() -> {
                int number = new Random().nextInt(100);
                System.out.println(Thread.currentThread().getName() + " : " + number);
                return number;
            }, 1, TimeUnit.SECONDS);

            // 打印每个线程运行后得到的值
            try {
                System.out.println(schedule.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        // 判断线程池是否关闭
        System.out.println("线程池未关闭： " + pool.isShutdown());
        // 线程池用完以后，需要关闭。不然会一直占着资源
        // 该方法是等待所有线程执行完后才关闭线程池
        pool.shutdown();
        System.out.println("线程池已关闭： " + pool.isShutdown());
        // 该方法是主线程运行到此就立即关闭线程
//        pool.shutdownNow();
    }

}

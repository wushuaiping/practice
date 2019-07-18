package io.wooo.practice.studyplan.juc;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *  线程池demo
 * Created by wushuaiping on 2019/7/18
 */
public class TestThreadPool {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<Integer> submit = pool.submit(() -> new Random().nextInt(100));
            try {
                System.out.println(submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }
}
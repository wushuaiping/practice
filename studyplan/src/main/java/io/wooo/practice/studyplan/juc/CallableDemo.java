package io.wooo.practice.studyplan.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by wushuaiping on 2019/7/11
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadCallableDemo threadDemo = new ThreadCallableDemo();
        FutureTask<Integer> futureTask = new FutureTask<>(threadDemo);
        new Thread(futureTask).start();
        Integer result = futureTask.get();
        System.out.println(result);
        System.out.println("------------------------");
    }

}

class ThreadCallableDemo implements Callable {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
}
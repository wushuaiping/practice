package io.wooo.practice.studyplan.juc.cas;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wushuaiping
 * @date 2019/7/16 10:48
 */
public class AtomicDemo {

    public static void main(String[] args) {
        final Test test = new Test(1, ":1");
        final Test test3 = new Test(3, ":1");
        AtomicReference<Test> reference = new AtomicReference<>(test);
        final boolean b = reference.compareAndSet(test, test3);
        System.out.println(b);
    }


}

@AllArgsConstructor
class Test{
    private int i;
    private String b;
}
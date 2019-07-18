package io.wooo.practice.studyplan.juc;

/**
 *  测试synchronized锁静态方法与synchronized锁实例方法的区别
 * Created by wushuaiping on 2019/7/17
 */
public class TestThread8Monitor {

    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();
        new Thread(() -> number.getOne()).start();
        new Thread(() -> number2.getTwo()).start();
    }

}

class Number{

    public static synchronized void getOne(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo(){
        System.out.println("two");
    }
}
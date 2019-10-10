package io.wooo.practice.studyplan.test;

/**
 * @author wushuaiping
 * @date 2019/9/11 11:32
 */
public class Synchronized {

    public static void main(String[] args) {
        synchronized (Synchronized.class) {
        }
        m();
    }

    static synchronized void m() {
    }
}

package io.wooo.practice.studyplan.juc;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wushuaiping
 * @date 2019/7/25 16:20
 */
public class SpinLock {

    private AtomicReference<Thread> cas = new AtomicReference<>();

    public void lock() {
        final Thread thread = Thread.currentThread();
        // 利用cas， 当前线程一直循环，等待expect变为null，如果expect为null，说明其他锁已经释放锁了。
        // 把内存值成功改为当前线程，说明当前线程获得锁，如果未修改成功，则说明当前线程获取锁失败。继续尝试获取锁。
        while (cas.compareAndSet(null, thread)) {
        }
    }

    public void unlock() {
        final Thread thread = Thread.currentThread();
        // 把内存值设为空，即释放了锁
        cas.compareAndSet(thread, null);
    }

}

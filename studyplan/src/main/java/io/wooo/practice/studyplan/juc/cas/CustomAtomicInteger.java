package io.wooo.practice.studyplan.juc.cas;

import sun.misc.Unsafe;

/**
 *  自定义原子锁
 * Created by wushuaiping on 2019/7/17
 */
public class CustomAtomicInteger {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(CustomAtomicInteger.class.getDeclaredField("value"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private volatile int value;

    public CustomAtomicInteger(int initVal){
        value = initVal;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int newVal) {
        this.value = newVal;
    }

    public final boolean compareAndSet(int expVal, int updateVal){
        return unsafe.compareAndSwapInt(this, valueOffset, expVal, updateVal);
    }

    public final int incrementAndGet(){
        return unsafe.getAndAddInt(this, valueOffset, 1);
    }

    public final int decrementAndGet(){
        return unsafe.getAndAddInt(this, valueOffset, -1);
    }

    public final int addAndGet(int updateVar){
        return unsafe.getAndAddInt(this, valueOffset, updateVar);
    }
}

package com.gupaoeu.vip.reentrantLockTest.conditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author：zhengqh
 * @date 2020/1/19 18:03
 **/
public class ConditionNotify  implements  Runnable {
    private Lock  lock;
    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try{
            lock.lock();
            System.out.println("begin---conditionNotify");
            condition.signal();
            System.out.println("end---conditionNotify");
        }finally {
            lock.unlock();
        }
    }
}

package com.gupaoeu.vip.reentrantLockTest.conditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author：zhengqh
 * @date 2020/1/19 18:01
 **/
public class ConditionWait  implements  Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }


    @Override
    public void run() {
         lock.lock();
         try {
             try {
                 System.out.println("begin--contitionWait");
                 condition.await();
                 System.out.println("end--contitionWait");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }finally {
             lock.unlock();
         }
    }
}

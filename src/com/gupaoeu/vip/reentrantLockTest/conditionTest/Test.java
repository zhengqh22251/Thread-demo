package com.gupaoeu.vip.reentrantLockTest.conditionTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：zhengqh
 * @date 2020/1/19 18:05
 **/
public class Test {
    public static void main(String[] args) {
         Lock lock = new ReentrantLock();
         Condition  condition = lock.newCondition();

//         new Thread(()->{new ConditionWait(lock,condition);}).start();
//         new Thread(()->{new ConditionNotify(lock,condition);}).start();

         new Thread(new ConditionWait(lock,condition)).start();
         new Thread(new ConditionNotify(lock,condition)).start();


    }
}

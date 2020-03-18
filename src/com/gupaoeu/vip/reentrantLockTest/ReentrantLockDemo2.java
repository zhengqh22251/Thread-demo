package com.gupaoeu.vip.reentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：zhengqh
 * @date 2020/1/19 15:08
 **/
public class ReentrantLockDemo2 {
    private static  int i =0;
    static  Lock lock = new ReentrantLock();//重入锁
    public static void incr(){
         lock.lock();
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 1000; j++) {
           new Thread(ReentrantLockDemo2::incr).start();
        }
        Thread.sleep(3000);
        System.out.println(i);
    }
}

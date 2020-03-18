package com.gupaoeu.vip.countDownlauthtest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author：zhengqh
 * @date 2020/3/17 10:10
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            System.out.println("Thread1");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("Thread2");
            countDownLatch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("Thread3");
            countDownLatch.countDown();
        }).start();
        System.out.println("before");
        countDownLatch.await();
        System.out.println("after");
    }
}

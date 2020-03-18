package com.gupaoeu.vip.countDownlauthtest;

import java.util.concurrent.CountDownLatch;

/**
 * @Author：zhengqh
 * @date 2020/3/17 10:15
 **/
public class Test2 extends Thread {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
             new Test2().start();
        }
        countDownLatch.countDown();//释放1000个线程
    }

    @Override
    public void run() {
        try {
            countDownLatch.await(); //阻塞1000个线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread name--->"+Thread.currentThread().getName());
    }
}

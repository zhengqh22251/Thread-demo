package com.gupaoeu.vip.reentrantLockTest.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author：zhengqh
 * @date 2020/3/16 13:53
 **/
public class InterruptExDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){//默认 false
                try {
                    TimeUnit.SECONDS.sleep(2);//中断处于一个阻塞状态的线程
                    // 复位+ 会抛出异常 但是任务还会继续跑
                    System.out.println("只是给他个信号，任务继续跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}

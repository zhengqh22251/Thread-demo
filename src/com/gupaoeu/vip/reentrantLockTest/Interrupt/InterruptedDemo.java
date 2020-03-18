package com.gupaoeu.vip.reentrantLockTest.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author：zhengqh
 * @date 2020/3/16 13:53
 **/
public class InterruptedDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while(true){//默认 false
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("1--->?"+Thread.currentThread().isInterrupted());
                    System.out.println(Thread.interrupted());//复位 回到初始的false,返回复位前的状态
                    System.out.println("2--->?"+Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("3--->?"+thread.isInterrupted());
        thread.interrupt();//false -->true
        System.out.println("4--->?"+thread.isInterrupted());
        thread.interrupt();
        System.out.println("5--->?"+thread.isInterrupted());
    }
}

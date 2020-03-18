package com.gupaoeu.vip.reentrantLockTest.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @Author：zhengqh
 * @date 2020/3/16 13:53
 **/
public class InterruptDemo {
    private static int i ;
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            while(!Thread.currentThread().isInterrupted()){//默认 false
                i++;
            }
            System.out.println(i);
        });

        thread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
      /*  System.out.println(Thread.currentThread().isInterrupted()); //false
        System.out.println("thread---》"+thread.isInterrupted() );//false
        thread.interrupt();
        System.out.println(Thread.currentThread().isInterrupted());//false
        System.out.println("thread---》"+thread.isInterrupted() );//true

        System.out.println(Thread.currentThread().interrupted());//false
        System.out.println("thread---》"+thread.isInterrupted() );//true


        System.out.println(Thread.interrupted());*/








        //    public static boolean interrupted() {
        //        return currentThread().isInterrupted(true);
        //    }
    }
}

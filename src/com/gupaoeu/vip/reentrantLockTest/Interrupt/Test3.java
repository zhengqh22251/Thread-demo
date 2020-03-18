package com.gupaoeu.vip.reentrantLockTest.Interrupt;

import org.omg.PortableServer.THREAD_POLICY_ID;

/**
 * @Author：zhengqh
 * @date 2020/3/17 21:07
 **/
public class Test3 {
    public static void main(String[] args) {
        Thread t =new Thread("zqh");
      /*  t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(Thread.currentThread().isInterrupted());//main线程

        Thread.currentThread().interrupt();
        System.out.println(Thread.currentThread().isInterrupted());//main线程*/
       // Thread.currentThread().interrupt();
        t.interrupt();
        System.out.println(t.isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.currentThread().isInterrupted());//main线程


    }
}

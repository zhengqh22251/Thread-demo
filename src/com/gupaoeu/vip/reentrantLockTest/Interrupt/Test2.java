package com.gupaoeu.vip.reentrantLockTest.Interrupt;

/**
 * @Author：zhengqh
 * @date 2020/3/17 20:03
 **/
public class Test2 {
    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        thread.interrupt();
        System.out.println("第一次调用thread.isInterrupted()："+thread.isInterrupted());
        Thread.currentThread().interrupt();
        System.out.println("第二次调用thread.isInterrupted()："+thread.isInterrupted());
        //测试interrupted（）函数
        System.out.println("第三次调用thread.interrupted()："+thread.interrupted());
        System.out.println("第四次调用thread.interrupted()："+thread.interrupted());
        System.out.println("thread是否存活："+thread.isAlive());

        System.out.println("---------------------------");

       /* Thread.currentThread().interrupt();
        System.out.println("第一次调用Thread.currentThread().interrupt()："
                +Thread.currentThread().isInterrupted());
        System.out.println("第一次调用thread.interrupted()："
                +Thread.currentThread().interrupted());
        System.out.println("第二次调用thread.interrupted()："
                +Thread.currentThread().interrupted());*/



   }
}

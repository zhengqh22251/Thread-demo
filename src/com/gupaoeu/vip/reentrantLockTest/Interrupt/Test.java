package com.gupaoeu.vip.reentrantLockTest.Interrupt;

/**
 * @Author：zhengqh
 * @date 2020/3/17 20:03
 **/
public class Test {
    public static void main(String[] args) {
        try {
            System.out.println();
            System.out.println("1-->"+Thread.currentThread().isInterrupted());//输出false
            Thread.currentThread().interrupt();//当前线程中断
            System.out.println("2-->"+Thread.currentThread().isInterrupted());//输出true
            System.out.println("3-->"+Thread.interrupted());// 返回当前状态  并且重置为 false 输出true
            System.out.println("4-->"+Thread.currentThread().isInterrupted());// 输出false
            Thread.sleep(3000);//中断后执行sleep会抛出异常
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("5-->"+Thread.currentThread().isInterrupted());//输出false
        }
    }
}

package com.gupaoeu.vip.joinDemo;

/**
 * @Author：zhengqh
 * @date 2020/3/16 19:16
 **/
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1");
        });
        Thread t2 =  new Thread(()->{
            System.out.println("t2");
        });
        Thread t3 =  new Thread(()->{
            System.out.println("t3");
        });
        t1.start();
        t1.join();//阻塞主线程  基于wait/notify通信  等待t1执行完 notifyall 阻塞的线程  main
        t2.start();
        t2.join();
        t3.start();
    }
}

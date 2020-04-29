package com.gupaoeu.vip.volatileDemo;

/**
 * @Author：zhengqh
 * @date 2020/3/30 18:02
 **/
public class ThreadMethodTest {
    static String A = new String("a");
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(()->{
            synchronized (A){
                System.out.println("123");
            }
        },"t1");
        Thread t2 =new Thread(()->{
            synchronized (A){
            }
        },"t2");
        t1.start();
        t2.start();
    }
}

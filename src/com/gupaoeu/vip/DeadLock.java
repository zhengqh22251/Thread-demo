package com.gupaoeu.vip;

/**
 * @Author：zhengqh
 * @date 2020/3/29 12:00
 **/
public class DeadLock {
    private synchronized void  demo(){
        System.out.println(1111);
        demo2();
    }
    private void demo2(){
        synchronized (this){
            System.out.println(2222);
        }
    }
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        deadLock.demo();
    }
}

package com.gupaoeu.vip.reentrantLockTest;

/**
 * @Author：zhengqh
 * @date 2020/1/19 15:03
 **/
public class RerntantLockDemko {

    public  synchronized void demo1(){ //对象锁
        System.out.println("demo1");
        demo2();
    }

    public void demo2(){
        synchronized (this){//同一个对象锁
            System.out.println("demo2");
        }
    }

    public static void main(String[] args) {
        RerntantLockDemko  rerntantLockDemko = new RerntantLockDemko();
        new Thread(rerntantLockDemko::demo1).start();
    }
}

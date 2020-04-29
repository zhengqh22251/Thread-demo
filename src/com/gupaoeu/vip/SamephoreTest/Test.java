package com.gupaoeu.vip.SamephoreTest;

import java.util.concurrent.Semaphore;

/**
 * @Author：zhengqh
 * @date 2020/3/17 10:37
 **/
public class Test {
    //Semaphore  可以实现限流   共享锁  公平 非公平
    static class car extends  Thread{
        private int num;
        private Semaphore semaphore;

        public car(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获取一个令牌
                System.out.println("第"+num+"辆车抢占了一个车位！");
                Thread.sleep(2000);
                System.out.println("第"+num+"开走了！");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);// 令牌数量
        for (int i = 0; i <10 ; i++) {
             new car(i,semaphore).start();
        }
    }
}

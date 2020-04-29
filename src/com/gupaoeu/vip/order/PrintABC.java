package com.gupaoeu.vip.order;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：zhengqh
 * @date 2020/4/28 15:49
 **/
public class PrintABC implements Runnable{
    // 打印完10次ABC后打印66666
    private volatile static int state = 0;
    private static CyclicBarrier cyclicBarrier =
            new CyclicBarrier(3,new PrintABC());
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while(state<=30){
                    lock.lock();
                    if(state%3==0){
                        System.out.print("A");
                        state++;
                    }
                    lock.unlock();
                }
                try {
                    cyclicBarrier.await();//  倒入完 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                while(state<=30){
                    lock.lock();
                    if(state%3==1){
                        System.out.print("B");
                        state++;
                    }
                    lock.unlock();
                }
                try {
                    cyclicBarrier.await();//  倒入完 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                while(state<=30){
                    lock.lock();
                    if(state%3==2){
                        System.out.println("C");
                        state++;
                    }
                    lock.unlock();
                }
                try {
                    cyclicBarrier.await();//  倒入完 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

    }

    @Override
    public void run() {
        System.out.println("6666666666");
    }
}

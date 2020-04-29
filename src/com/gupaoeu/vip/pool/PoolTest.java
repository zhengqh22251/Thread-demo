package com.gupaoeu.vip.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author：zhengqh
 * @date 2020/3/18 13:44
 **/
public class PoolTest implements Runnable{
    static ExecutorService executorService =  Executors.newFixedThreadPool(5);
                                              //ThreadPoolExecutor

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            executorService.execute(new PoolTest());
        }
        executorService.shutdown();
    }

    @Override
    public void run() {
        System.out.println("Thread Name--->"+Thread.currentThread().getName());
    }
}

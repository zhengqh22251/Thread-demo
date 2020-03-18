package com.gupaoeu.vip.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author：zhengqh
 * @date 2020/3/17 21:40
 **/
public class BlockingTest {
    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(10);
    {
        init();
    }

    private void init() {
        new Thread(()->{
          for(;;){
                try {
                    String data = arrayBlockingQueue.take();
                    System.out.println("消费：---》"+data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }).start();
    }

    private void add(String data) throws InterruptedException {
            arrayBlockingQueue.add(data);
            System.out.println("生产：---》"+data);
            Thread.sleep(1000);
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <100 ; i++) {
            new BlockingTest().add("垃圾食品"+i);
        }
    }
}

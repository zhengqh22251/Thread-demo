package com.gupaoeu.vip.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author：zhengqh
 * @date 2020/3/30 16:59
 **/
public class TestBlocking {
    ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue(5);
     {
        init();
     }

    private void init() {
         new Thread(()->{
             try {
                 Thread.sleep(2000);
                 String data = arrayBlockingQueue.take();
                 System.out.println("消费："+data);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();
    }

    public void add(String value) {
        arrayBlockingQueue.add(value);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            new TestBlocking().add("食品"+i);
            System.out.println("生产："+("食品"+i));
        }
    }
}

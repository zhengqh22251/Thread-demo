package com.gupaoeu.vip.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author：zhengqh
 * @date 2020/4/29 14:12
 **/
public class Test {
    ArrayBlockingQueue<String> arrayBlockingQueue =new ArrayBlockingQueue<>(5);
    {
        init();
    }

    private void init() {
       new Thread(()->{
           while(true){
               try {
                   String data =  arrayBlockingQueue.take();
                   System.out.println("消费："+data);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       }).start();
    }
    private void add(String data){
        arrayBlockingQueue.offer(data);
        System.out.println("生产："+data);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        for (int i = 0; i < 10; i++) {
            test.add("食品"+i);
        }
    }
}

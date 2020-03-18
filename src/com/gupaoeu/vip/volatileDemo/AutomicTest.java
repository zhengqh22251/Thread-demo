package com.gupaoeu.vip.volatileDemo;

import sun.awt.windows.ThemeReader;

/**
 * @Author：zhengqh
 * @date 2020/3/16 15:22
 **/
public class AutomicTest {

    private static int i= 0;

   public /*synchronized */ static void incr(){  // 这两个是等价的 都是类锁  缩锁范围 锁住的是什么  生命周期
       synchronized(AutomicTest.class){
           try {
               Thread.sleep(1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           i++;
       }

    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j <1000 ; j++) {
             new Thread(()->{
                  AutomicTest.incr();
             }).start();
        }
        Thread.sleep(5000);
        System.out.println(i);
    }
}

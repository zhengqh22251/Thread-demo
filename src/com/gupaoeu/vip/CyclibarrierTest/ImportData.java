package com.gupaoeu.vip.CyclibarrierTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author：zhengqh
 * @date 2020/3/17 10:52
 **/
public class ImportData extends Thread{
    private String  path;
    private CyclicBarrier cyclicBarrier;

    public ImportData(String path, CyclicBarrier cyclicBarrier) {
        this.path = path;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("开始导入"+path+"的数据");
        try {
            cyclicBarrier.await();//  倒入完 阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

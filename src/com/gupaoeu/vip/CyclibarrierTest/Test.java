package com.gupaoeu.vip.CyclibarrierTest;

import java.util.concurrent.CyclicBarrier;

/**
 * @Author：zhengqh
 * @date 2020/3/17 10:52
 **/
public class Test extends Thread{
    // Cyclibarrier 栅栏屏障  执行完屏障内的线程 再执行传入对象的线程run方法   CountDownlatch 也可以实现
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(3,new Test());
        new ImportData("file1",cyclicBarrier).start();
        new ImportData("file2",cyclicBarrier).start();
        new ImportData("file3",cyclicBarrier).start();
    }

    @Override
    public void run() {
        System.out.println("导入完成，数据分析");
    }
}

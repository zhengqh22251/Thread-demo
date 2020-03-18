package com.gupaoeu.vip.CallnableAndFuture;

import java.util.concurrent.*;

/**
 * @Author：zhengqh
 * @date 2020/3/18 13:49
 **/
public class Test implements Callable<String> {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test test = new Test();
       /* FutureTask futureTask = new FutureTask(test);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());//阻塞获取
*/
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future future =  executorService.submit(test);
        //executorService.shutdown();
        //executorService.shutdownNow();
        System.out.println(future.get());



    }

    @Override
    public String call() throws Exception {
        System.out.println("start-----");
        Thread.sleep(5000);
        return "hello callable";
    }
}

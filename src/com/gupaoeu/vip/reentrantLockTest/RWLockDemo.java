package com.gupaoeu.vip.reentrantLockTest;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author：zhengqh
 * @date 2020/1/19 15:15
 **/
public class RWLockDemo {
    static Map<String,Object> map = new HashMap();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();// 重入读写锁
    static Lock read = rwl.readLock();//读锁
    static Lock write = rwl.writeLock();//写锁

    public  final static Object get(String key){

        System.out.println("开始读数据");
        read.lock();
        try {
            return map.get(key);
        }finally {
           read.unlock();
        }
    }

    public static final void put(String key,Object value){
        System.out.println("开始写数据");
        write.lock();
        try{
            map.put(key,value);
        }finally {
            write.unlock();
        }
    }
}

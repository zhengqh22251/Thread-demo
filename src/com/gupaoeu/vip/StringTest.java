package com.gupaoeu.vip;

/**
 * @Author：zhengqh
 * @date 2020/3/30 17:38
 **/
public class StringTest {
    //String s = "abc";
    //这句是定义一个String变量s，jvm会先去字符串池中找有没有"abc"，有的话就把s指向"abc"，
    // 没有就会先在池中创建一个，再让s指向"abc"。

    //String s = new String("abc");
    //这句是先定义一个String变量s，然后在内存中分配新的空间"abc"再让s指向这个内存地址。
    public static void main(String[] args) {
        String a =  "hello";
        String b =  "hello";
        String c =  b;
        System.out.println(a==b);//true
        System.out.println(c==b);//true
        System.out.println(c==a);//true
        /*System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());*/
        System.out.println("---------------------");
        String d = new String("hello");
        String e = new String("hello");
        String f = e;
        System.out.println(d==e);//false
        System.out.println(d==f);//false
        System.out.println(e==f);//true
        System.out.println("---------------------");
        System.out.println(a==d);//false
        System.out.println(a==e);//false
        System.out.println(a==f);//false



    }
}

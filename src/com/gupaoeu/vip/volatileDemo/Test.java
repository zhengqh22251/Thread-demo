package com.gupaoeu.vip.volatileDemo;

import java.util.Arrays;

/**
 * @Author：zhengqh
 * @date 2020/3/29 17:14
 **/
//输入一个数组 如 1234 ，输出所有组合  123 132 213 231 312 321
public class Test {

    public static void main(String[] args) {
      /*  int[] array={1,2,3};
        allSort(array, 0, array.length-1);*/

        int [] a= {1,2,3,4};
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
            for(int j = 0;j<a.length;j++){
                if(a[i]!=a[j]){
                    System.out.print(a[j]);
                }
            }
            System.out.println("");
        }

    }
    static void allSort(int[] array,int begin,int end){
     //打印数组的内容
        if(begin==end){
            System.out.println(Arrays.toString(array));
            return;
        }
     //把子数组的第一个元素依次和第二个、第三个元素交换位置
        for(int i=begin;i<=end;i++){
            swap(array,begin,i );
            allSort(array, begin+1, end);
            //交换回来
            swap(array,begin,i );
        }
    }

    static void swap(int[] array,int a,int b){
        int tem=array[a];
        array[a]=array[b];
        array[b]=tem;
    }
}

package com.lgc.sort;

import java.util.Arrays;

/** 冒泡排序
 * @author lgc
 * @create 2020-01-12 3:39 下午
 **/
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{2,1,3})));
    }
    static int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j <arr.length-i-1 ; j++) {
                if (arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
}

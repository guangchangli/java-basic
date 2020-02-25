package com.lgc.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author lgc
 * @create 2020-01-12 3:54 下午
 **/
public class SelectSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectSort(new int[]{2, 3, 4, 1, 0})));
    }

    static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
                // continue;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}

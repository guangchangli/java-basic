package com.lgc.sort;

/**
 * 插入排序
 *
 * @author lgc
 * @create 2020-01-12 4:04 下午
 **/
public class InsertSort {
    public static void main(String[] args) {

    }

    static int[] insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                for (int j = 0; j < i - 1; j++) {
                    if (arr[j] < arr[i]) {
                    }
                }
            }
        }
        return arr;
    }
}

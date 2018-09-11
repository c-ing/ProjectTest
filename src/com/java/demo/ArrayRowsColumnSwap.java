package com.java.demo;



import java.util.Arrays;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;

/**
 * Created by cdc on 2018/2/25.
 */
public class ArrayRowsColumnSwap {

    public static void main(String[] args) {
        //创建二位数组
        int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("before Row Column Swap: ");
        for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));

        int arr2[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++ ){
            for (int j = 0; j < arr[i].length; j++){
                arr2[i][j] = arr[j][i];
            }
        }
        System.out.println("after Row Column Swap: ");
        for (int i = 0; i < arr2.length; i++)
            System.out.println(Arrays.toString(arr2[i]));
    }
}

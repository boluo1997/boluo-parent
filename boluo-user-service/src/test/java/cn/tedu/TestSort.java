package cn.tedu;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        int [] arr = {42,52,7,99,63,25,56,78,49};

        System.out.println(Arrays.toString(arr));

        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        quickSort(arr,low,high);
    }

    private static void quickSort(int[] arr, int low, int high) {

        if(low < high){

            //分区 返回分区界限索引
            int index = partition(arr,low,high);

            //对左边进行快速排序 左边low不变
            quickSort(arr,low,index-1);

            //对右边进行快速排序 右边high不变
            quickSort(arr,index+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        //指定左指针i 和右指针j
        int i = low;
        int j = high;

        //将第一个数指定为基准值   挖坑
        int x = arr[low];

        //使用循环实现分区操作
        while(i<j){    //i<j 就一直重复这个操作

            //  1.从右向左移动j,找到第一个小于基准值的值arr[j]
            while(arr[j] >= x && i<j){
                j--;
            }

            //  2.将第一步找到的值放入坑中,i++      这一步做完之后arr[j]就少了一位数 成为坑
            if(i<j){
                arr[i] = arr[j];
                i++;
            }

            //  3.从左向右移动i,找到第一个大于等于基准值的arr[i]
            while(arr[i] <= x && i<j){
                i++;
            }

            //  4.将第三步找到的值放入第二步的坑中,j--
            if(i<j){
                arr[j] = arr[i];
                j--;
            }

        }


        //使用基准值填坑   这就是基准值的最终位置
        arr[i] = x;     //此时i = j

        //返回基准值位置的索引
        return i;

    }


}














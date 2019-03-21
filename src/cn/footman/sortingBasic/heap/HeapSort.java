package cn.footman.sortingBasic.heap;

/**
 * @author footman77
 * @create 2018-11-17 21:09
 */
// 不使用一个额外的最大堆, 直接在原数组上进行原地的堆排序

public class HeapSort {
    public HeapSort() {
    }


    public static void sort(Comparable[] arr){
        int n = arr.length;

        // 注意，此时我们的堆是从0开始索引的
        // 从(最后一个元素的索引-1)/2开始
        // 最后一个元素的索引 = n-1
        for(int i = (n - 1 - 1) / 2; i >= 0; i--){
            siftDown(arr,n,i);
        }

        for(int i = n - 1; i > 0; i--){
            swap(arr,0,i);
            siftDown(arr,i,0);
        }

    }


    public static void swap(Object[] arr,int i, int j){
        Object temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 原始的shiftDown过程
    public static void siftDown(Comparable[] arr,int n,int k){
        while (k * 2 + 1 < n){
            int j = 2 * k + 1;
            if(j + 1 < n && arr[j].compareTo(arr[j + 1]) < 0){
                j++;
            }
            if(arr[k].compareTo(arr[j]) > 0){
                break;
            }
            swap(arr,k,j);
            k = j;
        }
    }


}

package cn.footman.sortingBasic.mergeSort;

import cn.footman.sortingBasic.insertionSort.InsertionSort;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-15 19:20
 */
public class MergeSortBU {
    private MergeSortBU(){

    }

    private static void merge(Comparable[] arr, int l, int mid, int r){
        //不包括r+1
        Comparable[] aux = Arrays.copyOfRange(arr, l, r + 1);

//        Comparable[] aux = new Comparable[arr.length];

        int i = l;
        int m = mid + 1;
        int k = 0;
        while (i <= mid && m <= r){
            if (arr[i].compareTo(arr[m]) < 0){
                aux[k++] = arr[i++];
            }else {
                aux[k++] = arr[m++];
            }
        }
        while (i <= mid){
            aux[k++] = arr[i++];
        }
        while (m <= r){
            aux[k++] = arr[m++];
        }
        for(int z = 0; z < aux.length;z ++){
            arr[l + z] = aux[z];
        }

    }


    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int sz = 1; sz <= n; sz *= 2){
            for(int i = 0; i < n - sz; i += sz + sz){
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr,i,i + sz -1,Math.min(i+sz+sz-1,n-1));
            }
        }

        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
//        if(n < 16){
//
//        }
//        for( int i = 0 ; i < n ; i += 16 )
//            InsertionSort.sort(arr, i, Math.min(i+15, n-1) );
//
//        for( int sz = 16; sz < n ; sz += sz )
//            for( int i = 0 ; i < n - sz ; i += sz+sz )
//                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
//                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
//                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );
//

    }


}

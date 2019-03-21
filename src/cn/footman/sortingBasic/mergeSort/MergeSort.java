package cn.footman.sortingBasic.mergeSort;

import cn.footman.sortingBasic.helper.SortTestHelper;
import cn.footman.sortingBasic.insertionSort.InsertionSort;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-15 16:38
 */
public class MergeSort {

    private MergeSort(){}
    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
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

    private static void sort(Comparable[] arr, int l,int r){

        if((r - l) <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }
//
//        if(r <= l){
//            return;
//        }

        int mid = (r - l) / 2 + l;

        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        // 优化1: 对于arr[mid] <= arr[mid+1]的情况,不进行merge
        // 对于近乎有序的数组非常有效,但是对于一般情况,有一定的性能损失
        if(arr[mid].compareTo(arr[mid + 1]) > 0){
            merge(arr,l,mid,r);

        }


    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr,0,n - 1);
    }


    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr);

    }
}

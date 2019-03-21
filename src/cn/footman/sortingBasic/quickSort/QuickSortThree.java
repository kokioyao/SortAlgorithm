package cn.footman.sortingBasic.quickSort;

import cn.footman.sortingBasic.insertionSort.InsertionSort;

/**
 * @author footman77
 * @create 2018-11-16 16:06
 */
public class QuickSortThree {
    public QuickSortThree() {
    }



    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr,int l, int r){
        // 对于小规模数组, 使用插入排序
        if( (r - l) <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;// arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l + 1;// arr[lt+1...i) == v

        while (i < gt){
            if(arr[i].compareTo(v) < 0){
                swap(arr,lt + 1, i);
                i++;
                lt++;
            }else if(arr[i].compareTo(v) > 0){
                swap(arr,gt - 1,i);
                gt--;
            }else {// arr[i] == v
                i++;
            }
        }
        swap(arr,l,lt);

        sort(arr,l,lt - 1);
        sort(arr,gt,r);
    }


    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr,int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}

package cn.footman.sortingBasic.quickSort;

import cn.footman.sortingBasic.insertionSort.InsertionSort;

/**
 * @author footman77
 * @create 2018-11-16 15:45
 */
public class QuickSortTwo {
    private QuickSortTwo(){

    }


    private static int partition(Comparable[] arr, int l, int r) {

// 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap( arr, l , (int)(Math.random()*(r-l+1))+l );

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l+1, j = r;

        while (true){
            while (i <= r && arr[i].compareTo(v) < 0){
                i++;
            }
            while (j >= l + 1 && arr[j].compareTo(v) >0){
                j--;
            }
            if(i > j){
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }


        // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr,int l, int r){
        // 对于小规模数组, 使用插入排序
        if( (r - l) <= 15){
            InsertionSort.sort(arr,l,r);
            return;
        }
//        if(l >= r){
//            return;
//        }

        int p = partition(arr,l,r);
        sort(arr, l, p - 1);
        sort(arr,p + 1, r);

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

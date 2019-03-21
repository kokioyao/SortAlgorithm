package cn.footman.sortingBasic.insertionSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

/**
 * @author footman77
 * @create 2018-11-15 11:28
 */
public class InsertionSort {

    private InsertionSort(){

    }

    public static void sort(Comparable[] arr){
        for( int i = 1; i < arr.length; i++ ){
            //写法1
//            for(int j = i; j > 0; j-- ){
//                if(arr[j].compareTo(arr[j - 1]) < 0){
//                    swap(arr,j,j - 1);
//                }else {
//                    break;
//                }
//            }

            // 写法2
//            for( int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0 ; j--)
//                swap(arr, j, j-1);

            //写法3
            Comparable temp = arr[i];
            int j = i;
            for(; j > 0; j--){
                if(temp.compareTo(arr[j - 1]) < 0){
                    arr[j] = arr[j - 1];
                }else {
                    break;
                }
            }
            arr[j] = temp;
        }
    }


    // 对arr[l...r]的区间使用InsertionSort排序
    public static void sort(Comparable[] arr,int l,int r){

        for(int i = l + 1; i <= r; i++){
            Comparable e = arr[i];
            int j = i;
            for(; j > l && arr[j - 1].compareTo(e) > 0;j--){
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    private static void swap(Object[] arr,int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        int n = 10000;
//        Integer[] arr = SortTestHelper.generateRandomArray(n, 0, 10000);
//        SortTestHelper.testSort("cn.footman.sortingBasic.insertionSort.InsertionSort",arr);
//        Integer[] arr9 = {32,1,4,21,453,11};
//        sort(arr9);
//        SortTestHelper.printArray(arr9);
    }
}

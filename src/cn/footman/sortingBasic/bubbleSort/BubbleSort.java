package cn.footman.sortingBasic.bubbleSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

/**
 * @author footman77
 * @create 2018-11-16 20:38
 */
public class BubbleSort {

    public BubbleSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++ ){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void swap(Comparable[] arr, int i,int j){
        Comparable temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }


    public static void main(String[] args) {
        Integer[] arr = {23,42,654,21,765,23,867,32,12};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

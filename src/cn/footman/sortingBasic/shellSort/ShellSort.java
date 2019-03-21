package cn.footman.sortingBasic.shellSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-16 18:33
 */
public class ShellSort {
    public ShellSort() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int h = 1;
        while (h <= n / 3){
            h = 3 * h + 1;
        }

        while (h >= 1){

            for(int i = h; i < n;i++){
                Comparable e = arr[i];
                int j = i;

                for(; j >= h && e.compareTo(arr[j - h]) < 0 ; j -= h)
                    arr[j] = arr[j - h];


                arr[j] = e;
            }
            h = h/3;
        }

    }


    public static void main(String[] args) {
        Integer[] arr = {23,42,654,21,765,23,867,32,12};
        sort(arr);
        SortTestHelper.printArray(arr);
    }
}

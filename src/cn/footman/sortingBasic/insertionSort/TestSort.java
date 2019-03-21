package cn.footman.sortingBasic.insertionSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-15 12:12
 */
public class TestSort {
    public static void main(String[] args) {
        int N = 60000;
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
//        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 4);
        Integer[] arr1 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("cn.footman.sortingBasic.insertionSort.InsertionSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.selectionSort.SelectionSort",arr2);


    }
}

package cn.footman.sortingBasic.quickSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-16 14:48
 */
public class QuickTest {
    public static void main(String[] args) {
        int N = 100000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);



        System.out.println("===============");
        // 测试2 测试近乎有序的数组

        int swapTimes = 100;
//        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);



        System.out.println("==========");

        arr1 = SortTestHelper.generateRandomArray(N,0,10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);



    }
}

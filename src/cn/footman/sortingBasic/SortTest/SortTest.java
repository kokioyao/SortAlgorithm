package cn.footman.sortingBasic.SortTest;

import cn.footman.sortingBasic.helper.SortTestHelper;

import java.util.Arrays;

/**
 * @author footman77
 * @create 2018-11-16 20:38
 */
public class SortTest {
    public static void main(String[] args) {
        int N = 1000000;
        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr4 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr5 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr6 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr7 = Arrays.copyOf(arr1, arr1.length);



//        SortTestHelper.testSort("cn.footman.sortingBasic.selectionSort.SelectionSort",arr1);
//        SortTestHelper.testSort("cn.footman.sortingBasic.insertionSort.InsertionSort",arr2);
//        SortTestHelper.testSort("cn.footman.sortingBasic.shellSort.ShellSort",arr3);
//        SortTestHelper.testSort("cn.footman.sortingBasic.bubbleSort.BubbleSort",arr4);
//        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort1",arr5);

        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort1",arr5);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort2",arr6);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort",arr7);


        System.out.println("---------------------------");
        // 测试2 测试近乎有序的数组
        int swapTimes = 100;
        assert swapTimes >= 0;

        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort1",arr5);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort2",arr6);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort",arr7);


        System.out.println("------------------");

        // 测试3 测试存在包含大量相同元素的数组
        System.out.println("Test for random array, size = " + N + " , random range [0,10]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 10);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);
        arr4 = Arrays.copyOf(arr1, arr1.length);
        arr5 = Arrays.copyOf(arr1, arr1.length);
        arr6 = Arrays.copyOf(arr1, arr1.length);
        arr7 = Arrays.copyOf(arr1, arr1.length);


        SortTestHelper.testSort("cn.footman.sortingBasic.mergeSort.MergeSort",arr1);
        // 这种情况下, 普通的QuickSort退化为O(n^2)的算法, 不做测试
        //        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSort",arr2);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortTwo",arr3);
        SortTestHelper.testSort("cn.footman.sortingBasic.quickSort.QuickSortThree",arr4);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort1",arr5);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort2",arr6);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort",arr7);


    }
}

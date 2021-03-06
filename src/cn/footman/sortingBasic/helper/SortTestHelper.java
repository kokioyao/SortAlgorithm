package cn.footman.sortingBasic.helper;


import cn.footman.sortingBasic.selectionSort.SelectionSort;

import java.lang.reflect.Method;

/**
 * @author footman77
 * @create 2018-11-14 21:00
 */
public class SortTestHelper {


    // SortTestHelper不允许产生任何实例
    private SortTestHelper() {
    }

    // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
        assert rangeL <= rangeR;

        Integer[] arr =  new Integer[n];

        for(int i = 0; i < n; i++){
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        }
        return arr;

    }


    public static void printArray(Object[] arr){

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.println();
        return;
    }

    // 生成一个近乎有序的数组
    // 首先生成一个含有[0...n-1]的完全有序数组, 之后随机交换swapTimes对数据
    // swapTimes定义了数组的无序程度:
    // swapTimes == 0 时, 数组完全有序
    // swapTimes 越大, 数组越趋向于无序
    public static Integer[] generateNearlyOrderedArray(int n,int swapTimes){
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        for(int i = 0; i < swapTimes; i++){
            int a = (int)(Math.random() * n);
            int b = (int)(Math.random() * n);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        return arr;
    }



    public static boolean isSort(Comparable[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            if(arr[i].compareTo(arr[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }


    // 测试sortClassName所对应的排序算法排序arr数组所得到结果的正确性和算法运行时间
    public static void testSort(String sortClassName,Comparable[] arr){
        try {
            // 通过sortClassName获得排序函数的Class对象
            Class sortClass = Class.forName(sortClassName);
            Method sortMethod = sortClass.getMethod("sort", new Class[]{Comparable[].class});

            Object[] params = new Object[]{arr};
            long startTime = System.currentTimeMillis();



            sortMethod.invoke(null,params);

            long endTime = System.currentTimeMillis();

            assert isSort(arr);

            System.out.println(sortClass.getSimpleName() + ":" + (endTime - startTime) + "ms");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

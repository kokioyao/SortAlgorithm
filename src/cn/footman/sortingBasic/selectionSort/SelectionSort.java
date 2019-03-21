package cn.footman.sortingBasic.selectionSort;

import cn.footman.sortingBasic.helper.SortTestHelper;

/**
 * @author footman77
 * @create 2018-11-14 22:17
 */
public class SelectionSort {

    //算法类不允许产生任何实例
    private SelectionSort(){

    }


//    public static void sort(int[] arr){
//
//        int n = arr.length;
//        for(int i = 0; i < n - 1; i++){
//            int minIndex = i;
//            for(int j = i + 1; j < n; j++){
//                if(arr[minIndex] > arr[j]){
//                   minIndex = j;
//                }
//            }
//            swap(arr,i,minIndex);
//        }
//    }

    /**
     * 使能比较的类型都可以进行比较
     */
    public static void sort(Comparable[] arr){
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr,i,minIndex);
        }
    }


    private static void swap(Object[] arr,int i, int j){
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {
//        //测试Integer
//        Integer[] arr = {3,4,2,5,6,1,0};
//        SelectionSort.sort(arr);
//        SortTestHelper.printArray(arr);
//
//        //Double
//        Double[] b = {3.2,5.3,2.0,5.1};
//        SelectionSort.sort(b);
//        SortTestHelper.printArray(b);
//        //String
//        String[] s = {"a","c","e","d"};
//        SelectionSort.sort(s);
//        SortTestHelper.printArray(s);
//
//
//        //自定义类
//        Student s1 = new Student("A", 99);
//        Student s2 = new Student("E", 98);
//        Student s3 = new Student("D", 100);
//        Student s4 = new Student("B", 99);
//        Student[] ss = {s1,s2,s3,s4};
//        SelectionSort.sort(ss);
//        SortTestHelper.printArray(ss);

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,10000);
//        SelectionSort.sort(arr);
//        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("cn.footman.sortingBasic.selectionSort.SelectionSort",arr);



    }

}

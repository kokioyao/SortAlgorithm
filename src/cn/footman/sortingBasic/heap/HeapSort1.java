package cn.footman.sortingBasic.heap;

import cn.footman.sortingBasic.helper.SortTestHelper;

/**
 * @author footman77
 * @create 2018-11-16 23:43
 */
public class HeapSort1 {
    public HeapSort1() {
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

        for(int i = 0; i < n; i++){
            maxHeap.insert(arr[i]);
        }
        for(int i = n - 1; i >= 0; i--){
            arr[i] = maxHeap.extractMax();
        }
    }


    public static void main(String[] args) {
        int N = 1000000;

        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("cn.footman.sortingBasic.heap.HeapSort1",arr);
    }

}

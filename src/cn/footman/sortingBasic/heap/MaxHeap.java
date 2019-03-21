package cn.footman.sortingBasic.heap;

/**
 * @author footman77
 * @create 2018-11-16 22:46
 */
public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;


    public MaxHeap(int capacity){
        data = (Item[])new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(Item[] arr){
        int n = arr.length;
        data = (Item[])new Comparable[n + 1];
        capacity = n;

        for(int i = 0 ; i < n; i++){
            data[i+1] = arr[i];
        }
        count = n;

        for(int i = count / 2; i > 0; i--){
            siftDown(i);
        }

    }



    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }


    // 像最大堆中插入一个新的元素 item
    public void insert(Item item){
        assert( count + 1 <= capacity);
        data[count+1] = item;
        count++;
        siftup(count);
    }
    // 交换堆中索引为i和j的两个元素
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public void siftup(int k){
        while (k > 1 && data[k/2].compareTo(data[k]) < 0){
            swap(k/2,k);
            k = k / 2;
        }
    }

    public Item getMax(){
        assert (count > 0);
        return data[1];
    }


    public Item extractMax(){
        assert count > 0;
        Item ret = data[1];

        swap(1,count);
        count--;
        siftDown(1);
        return ret;
    }


    public void siftDown(int k){
        //要有孩子
        while (2 * k <= count){
            int j = 2 * k;// 在此轮循环中,data[k]和data[j]交换位置
            if(j + 1 <= count && data[j + 1].compareTo(data[j]) > 0){
                j++;
            }
            if(data[k].compareTo(data[j]) > 0){
                break;
            }
            swap(k,j);
            k = j;
        }
    }




    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)

        for(int i = 0; i < N; i++){
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for(int i = 0; i < N; i++){
            Integer integer = maxHeap.extractMax();
            arr[i] = integer;
            System.out.print(arr[i] + " ");
        }


//        System.out.println(maxHeap.size());
        System.out.println();
        for(int i = 1; i <= N; i++){
            assert arr[i - 1] > arr[i];
        }
    }

}

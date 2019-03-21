package cn.footman.sortingBasic.heap;

/**
 * @author footman77
 * @create 2018-11-18 0:56
 */
public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data;// 最大索引堆中的数据
    protected int[] indexes;// 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    protected int[] reverse;// 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    protected int count;
    protected int capacity;

    public IndexMaxHeap(int capacity){
        data = (Item[])new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for(int i = 0; i <= capacity; i++){
            reverse[i] = 0;
        }

        count = 0;
        this.capacity = capacity;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    public void insert(int i,Item item){

        assert count + 1 < capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;

        siftUp(count);
    }
    // 从最大索引堆中取出堆顶元素, 即索引堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item ret = data[indexes[1]];
        swapIndexes(1,count);
        reverse[indexes[count]] = 0;
        count--;
        siftDown(1);
        return ret;
    }

    // 从最大索引堆中取出堆顶元素的索引
    public int extractMaxIndex(){
        assert count > 0;

        int ret = indexes[1] - 1;
        swapIndexes(1,count);
        reverse[indexes[count]] = 0;

        count--;
        siftDown(1);
        return ret;
    }

    public Item getMax(){
        assert count > 0;
        return data[indexes[1]];
    }
    // 获取最大索引堆中的堆顶元素的索引
    public int getMaxIndex(){
        assert count > 0;
        return indexes[1] - 1;
    }
    // 看索引i所在的位置是否存在元素
    public boolean contain(int i){
        assert  i + 1 >= 1 && i + 1 <= capacity;
        return reverse[i + 1] != 0;
    }

    // 获取最大索引堆中索引为i的元素
    public Item getItem( int i ){
        assert i + 1 >= 1 && i + 1 <= capacity;
        return data[i+1];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i ,Item newItem){

        i += 1;
        data[i] = newItem;
        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
//        for(int j = 1; j <= count; j++){
//            if(indexes[j] == i){
//                siftUp(j);
//                siftDown(j);
//                return;
//            }
//        }

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        siftUp( reverse[i] );
        siftDown( reverse[i] );

    }


    // 交换索引堆中的索引i和j
    // 由于有了反向索引reverse数组，
    // indexes数组发生改变以后， 相应的就需要维护reverse数组
    public void swapIndexes(int i,int j){
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;

        reverse[indexes[i]] = i;
        reverse[indexes[j]] = j;
    }



    public void siftUp(int k){
        while (k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) < 0){
            swapIndexes(k,k/2);
            k = k/2;
        }
    }


    public void siftDown(int k){
        while (2 * k <= count){
            int j = 2 * k;
            if(j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) < 0){
                j++;
            }
            if(data[indexes[k]].compareTo(data[indexes[j]]) >= 0){
                break;
            }
            swapIndexes(j,k);
            k = j;
        }
    }



}

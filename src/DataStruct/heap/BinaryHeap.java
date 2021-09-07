package DataStruct.heap;
/** 二叉堆/优先队列 */
public abstract class BinaryHeap implements Heap {

    private int MaxSize = 0;
    /* 用数组来储存一棵完全二叉树 */
    private int[] arr = null;
    private int size = 0;
    /* 用来表示现在已经使用的节点数量 */
    /* 完全二叉树的下标必然是从1-n的 所以按顺序递增即可 */

    /* 初始化二叉堆 n代表堆的最大容量
    *  因为从0开始没办法很好的表示树
    *  所以第0位不包括在内 */
    public BinaryHeap(int n){
        /* 手动指定二叉堆的最大容量 */
        this.MaxSize = n;
        this.arr = new int[n+1];
    }

    /** 将父节点与子节点的大小进行比较(x是父节点,y是子节点) 若x>y为false->大根堆 若x<y为true->小根堆 */
    public abstract boolean compare(int x,int y);

    @Override
    public void push(int x) throws Exception {
        if (this.isFull()){
            throw new Exception(" 堆空间不足~ ");
            /* 满的话就抛错误 */
        }
        arr[++ this.size] = x;
        swim();
    }

    @Override
    public int pop() throws Exception{
        if (this.isEmpty()){
            throw new Exception(" 堆是空哒~ ");
        }
        int ans = arr[1];
        arr[1] = arr[this.size--];
        sink();
        return ans;
    }

    @Override
    public int top(){
        return this.arr[1];
    }

    public boolean isFull(){
        return this.size == MaxSize;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    private void swap(int a,int b){
        /* a,b代表数组的两个下标 */
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    private void swim(){
        /* 上浮 插入数据的时候直接把数据扔到叶子结点 然后和父节点比较并上浮 */
        for(int i = this.size; i>1&&compare(arr[i],arr[i/2]); i /= 2){
           swap(i/2, i);
        }
    }

    private void sink(){
        /* 弹出之后把最后一个叶子结点补到第一个位置 然后下沉 */
        for(int currentNode = 1, sonNode = son(currentNode); sonNode<=this.size &&compare(arr[sonNode],arr[currentNode]); currentNode=sonNode,sonNode=son(sonNode)){
            swap(sonNode,currentNode);
        }
    }

    private int son(int number){
        return 2*number + ((2*number+1<=this.size &&compare(arr[number*2+1],arr[number*2]) ?  1 : 0));
    }

}

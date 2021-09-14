package DataStruct.tree;
/**
 *  线段树
 *  **/
public class SegmentTree{

    private int[] arr = null;
    private int[] lazyMark = null;
    private int[] tree = null;

    public SegmentTree(int[] arr,int arrayBound){
        /* n是线段树存储区间的右边界 */
        this.arr         = arr;
        this.lazyMark    = new int[4*arrayBound+5];
        this.tree        = new int[4*arrayBound+5];
        build(1,arrayBound,1);
    }

    private void build(int rangeLeftBound, int rangeRightBound, int nodeNumber){
        if (rangeLeftBound == rangeRightBound){
            tree[nodeNumber] = arr[rangeLeftBound];
            /* 当前区间只有一个元素 结束递归 （当前元素为 arr[rangeLeftBound]）*/
            return ;
        }
        int rangeMidBound = (rangeLeftBound + rangeRightBound) / 2;
        /* 递归建立左子区间 */
        build(rangeLeftBound,rangeMidBound,nodeNumber * 2);
        /* 递归建立右字区间 */
        build(rangeMidBound+1,rangeRightBound,nodeNumber * 2 + 1);
        /* 按照树的存储方式 如果以数组存树(从下标1开始存) 当前节点的下标*2为左子树根的下标 当前节点的下标*2 + 1为右子树根的下标 */
        tree[nodeNumber] = tree[nodeNumber * 2] + tree[nodeNumber * 2 + 1];
        /* 建完要回滚 */
    }

    public int getSum(int wantedRangeLeftBound, int wantedRangeRightBound,int currentNodeRangeLeftBound,int currentNodeRangeRightBound, int currentNodeNumber){
        if (wantedRangeLeftBound<=currentNodeRangeLeftBound && wantedRangeRightBound >= currentNodeRangeRightBound){
            /* 当前节点是我们需要查询的区间的子集 即 wrL  crL   crR  wrR 这时就直接 返回当前区间的和 */
            return tree[currentNodeNumber];
        }
        down(currentNodeRangeLeftBound,currentNodeRangeRightBound,currentNodeNumber);
        int mid = (currentNodeRangeLeftBound + currentNodeRangeRightBound) / 2;
        int sum = 0;
        if (wantedRangeLeftBound<=mid){  /*左边区间还有油水可榨(还有节点没get到)*/
            sum += getSum(wantedRangeLeftBound,wantedRangeRightBound,currentNodeRangeLeftBound,mid,currentNodeNumber * 2);
        }
        if (wantedRangeRightBound >= mid + 1){
            sum += getSum(wantedRangeLeftBound,wantedRangeRightBound,mid+1,currentNodeRangeRightBound,currentNodeNumber * 2 + 1);
        }
        return sum;
    }

    public void update(int wantedRangeLeftBound, int wantedRangeRightBound,int currentNodeRangeLeftBound,int currentNodeRangeRightBound, int currentNodeNumber, int changeValue){
        if (wantedRangeLeftBound<=currentNodeRangeLeftBound && wantedRangeRightBound >= currentNodeRangeRightBound){
            tree[currentNodeNumber] += (currentNodeRangeRightBound-currentNodeRangeLeftBound + 1) * changeValue;
            /* 对区间值进行修改 */
            lazyMark[currentNodeNumber] += changeValue;
            /* 更新懒惰标记 不过叶子节点为什么要更新啊喂？ */
            /* 这个不一定是叶子节点 只要是子集即可返回 所以还是要更新啦*/
            return ;
        }
        down(currentNodeRangeLeftBound,currentNodeRangeRightBound,currentNodeNumber);
        int mid = (currentNodeRangeLeftBound + currentNodeRangeRightBound) / 2;
        if (wantedRangeLeftBound <= mid){  /*左边区间还有油水可榨(还有节点没get到)*/
            update(wantedRangeLeftBound,wantedRangeRightBound,currentNodeRangeLeftBound,mid,currentNodeNumber * 2,changeValue);
        }
        if (wantedRangeRightBound >= mid + 1){
            update(wantedRangeLeftBound,wantedRangeRightBound,mid+1,currentNodeRangeRightBound,currentNodeNumber * 2 + 1,changeValue);
        }
        tree[currentNodeNumber] = tree[currentNodeNumber * 2] + tree[currentNodeNumber * 2 + 1];
        /* 回滚 子节点更新完之后父节点再更新？ 不过说实话 我没看懂这个操作 */
    }


    private void down(int currentNodeRangeLeftBound, int currentNodeRangeRightBound,int currentNodeNumber){
        /* 下放懒惰标记 */
        int mid = (currentNodeRangeLeftBound + currentNodeRangeRightBound) / 2;
        if (lazyMark[currentNodeNumber]!=0) {
            /* 懒惰标记为空 代表这一段区间没有更新 所以不用向下更新 */
            tree[currentNodeNumber * 2]         += lazyMark[currentNodeNumber] * (mid - currentNodeRangeLeftBound + 1);
            tree[currentNodeNumber * 2 + 1]     += lazyMark[currentNodeNumber] * (currentNodeRangeRightBound - mid);
            /* 更新子节点 虽然更新了 但是元素并没有真的被更新 所以将懒惰标记下放 让子节点的子节点传下去 直到传到真实的元素为止 */
            lazyMark[currentNodeNumber * 2]     += lazyMark[currentNodeNumber];
            lazyMark[currentNodeNumber * 2 + 1] += lazyMark[currentNodeNumber];
            /* 祖传懒惰标记~ */
            lazyMark[currentNodeNumber] = 0;
        }
    }
}
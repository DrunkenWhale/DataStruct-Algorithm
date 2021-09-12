package DataStruct.graph;


/**
 *  链式向前星 一种存图的方式
 * 因为不需要排序 所以比向前星更加高效
 * (实在找不到英文译名...干脆叫这名字算了吧)
 * */
public class ChainForwardStar {

    public Edge[] edges;  // 储存图的边
    public int[]  heads;  // 举个栗子 heads[i] 储存的是以这个节点作为起点的边中序号最大的那个边在edges数组的下标
    public int index;     // 当前edge数组下标
    public int edgeNumber;   // 边的个数 即数组的大小
    public int nodeNumber;
    /**
     * @param edgeNumber 图的边的数量
     * @param nodeNumber 图的节点的数量
     * */
    public ChainForwardStar(int edgeNumber,int nodeNumber){
        this.edgeNumber = edgeNumber;
        this.nodeNumber = nodeNumber;
        this.edges  = new Edge[edgeNumber+1];
        this.heads  = new int[nodeNumber+1];
    }

    public void addEdge(int start,int end,int weightValue){  // 存图
        edges[++ index].to = end;
        edges[index].weightValue = weightValue;
        edges[index].next = heads[start];
        heads[start] = index;
    }


}

class Edge{                     // 有向图中的边
    public int to    ;          // 这条边的终点
    public int next  ;          // 跟这条边相同起点的下一条边 在数组中的下标
    public int weightValue;     // 这条边的权值
}

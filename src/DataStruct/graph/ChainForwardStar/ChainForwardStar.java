package DataStruct.graph.ChainForwardStar;


/**
 *  链式向前星 一种存图的方式
 * 因为不需要排序 所以比向前星更加高效
 * (实在找不到英文译名...干脆叫这名字算了吧)
 * */
public class ChainForwardStar {

    public Edge[] edges;  // 储存图的边
    public int[]  heads;  // 举个栗子 heads[i] 储存的是以这个节点作为起点的边中序号最大的那个边在edges数组的下标
    private int index = 1;     // 当前edge数组下标
    private final int edgeNumber;   // 边的个数 即数组的大小
    private final int nodeNumber;
    /**
     * @param edgeNumber 图的边的数量
     * @param nodeNumber 图的节点的数量
     * */
    public ChainForwardStar(int nodeNumber,int edgeNumber){
        this.edgeNumber = edgeNumber;
        this.nodeNumber = nodeNumber;
        this.edges  = new Edge[edgeNumber+1];
        this.heads  = new int[nodeNumber+1];
    }

    public void addEdge(int start,int end,int weightValue){  // 存图
        edges[index] = new Edge(end,heads[start],weightValue);
        heads[start] = index ++;
    }

    public void showEdges(){
        for (int i=1;i<=nodeNumber;++i){
            for (int j=heads[i];j>0;j=edges[j].next){
                System.out.printf("from: %5d to: %5d weight:%5d\n",i,edges[j].to,edges[j].weightValue);
            }
        }
    }

    public int getEdgeNumber() {
        return edgeNumber;
    }

    public int getNodeNumber() {
        return nodeNumber;
    }

}



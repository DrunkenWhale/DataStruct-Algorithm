package DataStruct.graph.ChainForwardStar;

public class Edge {   // 链式向前星储存方法中的有向边
    public int to;          // 这条边的终点
    public int next;          // 跟这条边相同起点的下一条边 在数组中的下标
    public int weightValue;     // 这条边的权值

    public Edge(int to, int next, int weightValue) {
        this.to = to;
        this.next = next;
        this.weightValue = weightValue;
    }
}

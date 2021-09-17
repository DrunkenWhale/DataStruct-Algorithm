package Algorithm;

import DataStruct.Pair;
import DataStruct.graph.ChainForwardStar.ChainForwardStar;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 迪杰特斯拉单源最短路径算法
 * */
public class Dijkstra {
    /**
     * @param start 路径起点
     * @param chainForwardStar 已经建好的链式向前星
     * */
    public static long[] init(int start, ChainForwardStar chainForwardStar){
        PriorityQueue<Pair<Long,Integer>> priorityQueue = new PriorityQueue<>(  // 距离短的
                (x,y)-> {
            if (x.first.equals(y.first)){
                return 0;
            }else if (x.first<y.first){
                return 1;
            }else {
                return -1;
            }
        });
        boolean[] mark = new boolean[chainForwardStar.getNodeNumber()+1];
        long[] distance = new long[chainForwardStar.getNodeNumber()+1];
        // 最大值
        Arrays.fill(distance, 0x7fffffff);
        distance[start] = 0;
        priorityQueue.add(new Pair<>(0L,start));   // 压进去的是(到起点的距离和当前节点的编号) 起始点和自身的距离是0
        while (!priorityQueue.isEmpty()){
            int temp = priorityQueue.peek().second;
            priorityQueue.poll();
            if (mark[temp]){ // 访问过了 跳过
                continue;
            }else {
                mark[temp] = true;
                for (int i=chainForwardStar.heads[temp];i>0;i=chainForwardStar.edges[i].next){
                    int end = chainForwardStar.edges[i].to;
                    if (distance[end] > distance[temp] + chainForwardStar.edges[i].weightValue){
                        distance[end] = distance[temp] + chainForwardStar.edges[i].weightValue;
                        priorityQueue.add(new Pair<>(distance[end], end));
                    }
                }
            }
        }
        return distance;
    }

}

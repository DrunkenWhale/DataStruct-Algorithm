package DataStruct.graph;

/**
 *  A elegant and simple ,interesting DataStruct
 *  It can solve some disjoint problem.
 *  It has two operations,include:
 *
 *  Find : to determine one point belong which subsets
 *
 *  Union: to merge two subset to one subset
 *
 *  Warning: Struct.Graph.DisjointSet doesn't support separating subset
 *
 *
 * */


public class DisjointSet {
    /** A odd array which deposit this Struct.Graph.DisjointSet class's node */
    public int[] node = null;

    /** Initialize this class.
     *  To set every node's father node is itself.
     *  We regulate one node is ancient node if its index equals its value
     *  (actually, its regulation makes find more convenient)*/
    public DisjointSet(int n){
        node = new int[n+1];
        for (int i=1;i<=n;++i){
            node[i] = i;
        }
    }

    /**
     * Find methods can return params' ancient node
     * @param params node's index, this function will make path compression when you find node's ancient
     *
     * */
    public int find(int params){
        while (params!=node[params]){
            params = node[params] = node[node[params]];
        }
        return params;
    }

    /** To make two subset merge to one subset.
     *  this method will return :
     *  true   ->  successful union!
     *  false  ->  two nodes in the same subset, needn't union!
     *  But eventually, after use this method, two node will in same subset.
     * */
    public boolean union(int x,int y){
        int xAncientNode = find(x);
        int yAncientNode = find(y);
        if (xAncientNode==yAncientNode){
            /* These two node in the same subset ,don't need to union*/
            return false;
        }else{
            /* To make two nodes have the same ancient node */
            node[xAncientNode] = find(yAncientNode);
            return true;
        }
    }

}

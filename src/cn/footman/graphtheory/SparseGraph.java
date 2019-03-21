package cn.footman.graphtheory;

import java.util.Vector;

/**
 * @author footman77
 * @create 2018-11-18 23:28
 */
// 稀疏图 - 邻接表
public class SparseGraph implements Graph {
    private int n;// 节点数
    private int m;// 边数
    private boolean directed;// 是否为有向图
    private Vector<Integer>[] g;// 图的具体数据


    public SparseGraph(int n, boolean directed){
        assert n >= 0;
        this.n = n;
        this.m = 0;
        this.directed = directed;// 初始化没有任何边

        g = (Vector<Integer>[]) new Vector[n];
        for(int i = 0; i < n; i++){
            g[i] = new Vector<Integer>();
        }
    }

    // 返回节点个数
    public int V(){
        return n;
    }
    // 返回边的个数
    public int E(){
        return m;
    }

    public void addEdge(int v, int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        g[v].add(w);
        if(v != w && !directed){
            g[w].add(v);
        }
        m++;
    }


    public boolean hasEdge(int v,int w){
        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        for(int i = 0; i < g[v].size(); i++){
            if(g[v].elementAt(i) == w){
                return true;
            }
        }
        return false;
    }

    @Override
    public void show() {
        for(int i = 0; i < n; i++){
            System.out.print("vertex " + i + ":\t");
            for(int j = 0 ; j < g[i].size(); j++){
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        return g[v];
    }

}



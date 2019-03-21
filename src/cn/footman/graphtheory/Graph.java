package cn.footman.graphtheory;

/**
 * @author footman77
 * @create 2018-11-18 23:52
 */
public interface Graph {
    public int V();
    public int E();
    public void addEdge( int v , int w );
    boolean hasEdge( int v , int w );
    void show();
    public Iterable<Integer> adj(int v);
}

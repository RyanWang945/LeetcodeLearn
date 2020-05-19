package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/8 10:26
 */
public class _1319 {
    public int makeConnected(int n, int[][] connections) {
        UnionFind unionFind=new UnionFind(n);
        int circle=0;
        for(int i=0;i<connections.length;i++){
            if(unionFind.find(connections[i][0])==unionFind.find(connections[i][1])){
                circle++;
            }else{
                unionFind.union(connections[i][0],connections[i][1]);
            }
        }
        int res=0;
        for(int i=0;i<unionFind.rank.length;i++){
            if(unionFind.rank[i]!=0)
                res++;
        }
        res--;
        return circle>=res?res:-1;
    }
    private class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int total){
            parent=new int[total];
            rank=new int[total];
            for(int i=0;i<total;i++){
                parent[i]=i;
                rank[i]=1;
            }
        }
        public int find(int x){
            if(x!=parent[x])
                parent[x]=find(parent[x]);
            return parent[x];
        }
        public void union(int p,int q){
            int pRoot=find(p);
            int qRoot=find(q);
            if(rank[pRoot]<rank[qRoot]){
                parent[pRoot]=qRoot;
                rank[pRoot]=0;
            }else if(rank[pRoot]>rank[qRoot]){
                rank[qRoot]=0;
                parent[qRoot]=pRoot;
            }else{
                parent[pRoot]=qRoot;
                rank[pRoot]=0;
                rank[qRoot]++;
            }
        }
    }
}

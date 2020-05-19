package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/7 20:43
 */
public class _684 {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res=new int[2];
        UnionFind unionFind=new UnionFind(edges.length);
        unionFind.union(edges[0][0] - 1, edges[0][1] - 1);
        for (int i = 1; i < edges.length; i++) {
            if (unionFind.find(edges[i][0] - 1) == unionFind.find(edges[i][1] - 1)) {
                res[0] = edges[i][0];
                res[1] = edges[i][1];
            } else {
                unionFind.union(edges[i][0] - 1, edges[i][1] - 1);
            }
        }
        return res;
    }
    private class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int total){
            parent=new int[total];
            rank=new int[total];
            for(int i=0;i<total;i++){
                parent[i]=i;
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
            if(pRoot==qRoot){
                return;
            }
            if(rank[pRoot]<rank[qRoot])
                parent[pRoot]=qRoot;
            else if(rank[pRoot]>rank[qRoot])
                parent[qRoot]=pRoot;
            else{
                parent[pRoot]=qRoot;
                rank[qRoot]+=1;
            }
        }
    }
}

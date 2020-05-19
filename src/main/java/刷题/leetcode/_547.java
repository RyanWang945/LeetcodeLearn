package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/8 9:59
 */
public class _547 {
    public int findCircleNum(int[][] M) {
        UnionFind unionFind=new UnionFind(M.length);
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
                if(M[i][j]==1){
                    unionFind.union(i,j);
                }
            }
        }
        int res=0;
        for(int i=0;i<unionFind.rank.length;i++){
            if(unionFind.rank[i]!=0)
                res++;
        }
        return res;
    }
    private class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int total){
            parent=new int[total];
            rank=new int[total];
            for(int i=0;i<total;i++)
                parent[i]=i;
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
            }
            else if(rank[pRoot]>rank[qRoot]){
                parent[qRoot]=pRoot;
                rank[qRoot]=0;
            }else{
                parent[pRoot]=qRoot;
                rank[pRoot]=0;
                rank[qRoot]++;
            }
        }
    }
}

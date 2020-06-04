package algorithmnote.并查集模板;

/**
 * @author Ryan
 * @date 2020/6/2 9:43
 */
public class UnionFindDemo {
}
class UnionFind{
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
        if(rank[pRoot]<rank[qRoot]) {
            parent[pRoot] = qRoot;
            rank[pRoot] = 0;
        }else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot]=pRoot;
            rank[qRoot]=0;
        }else{
            parent[pRoot]=qRoot;
            rank[qRoot]++;
            rank[pRoot]=0;
        }
    }
}

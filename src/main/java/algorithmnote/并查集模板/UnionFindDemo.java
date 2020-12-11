package algorithmnote.并查集模板;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 很多时候并查集的rank并不一定指的是树的深度，也可能指的是树的大小
 */
public class UnionFindDemo {
}
class UnionFind{
    int[] parent;
    int[] rank;
    //parent和rank数组到底是total还是total+1取决你的元素index，比如你的元素从0到total-1
    //就可以这么用，但如果是1到total，那就total+1吧，然后不需要用0位置了。
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

    class Pair{
        int i;
        int j;
        int w;
        public Pair(int i,int j,int w){
            this.i=i;
            this.j=j;
            this.w=w;
        }
    }
}

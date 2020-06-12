package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/6/8 9:49
 */
public class _990 {
    int num;
    int[] parent;
    int[] rank;
    public void init(int n){
        parent=new int[n];
        rank=new int[n];
        num=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(x!=parent[x])
            x=find(parent[x]);
        return parent[x];
    }
    public void union(int p,int q){
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot)
            return;
        num--;
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
            rank[qRoot]+=rank[qRoot];
        }else{
            parent[qRoot]=pRoot;
            rank[pRoot]+=rank[qRoot];
        }
    }
    public boolean equationsPossible(String[] equations) {
        init(26);
        for(String equation:equations){
            int x=equation.charAt(0)-'a';
            int y=equation.charAt(3)-'a';
            boolean equal=equation.charAt(1)=='=';
            if(equal==true)
                union(x,y);
        }
        for(String equation:equations){
            int x=equation.charAt(0)-'a';
            int y=equation.charAt(3)-'a';
            boolean equal=equation.charAt(1)=='=';
            if(equal==false){
                if(find(x)==find(y))
                    return false;
            }
        }
        return true;
    }
}

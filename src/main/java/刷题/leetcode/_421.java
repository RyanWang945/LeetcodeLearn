package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/29 11:31
 */
public class _421 {
    /**
     *bf,用时接近200ms，O(n^2)
     */
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                max=Math.max(max,nums[i]^nums[j]);
            }
        }
        return max;
    }
    private class TrieNode{
        TrieNode[] children=new TrieNode[2];
        public TrieNode(){
        }
    }
    private class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
        public void insert(int x){
            TrieNode temp=root;
            for(int i=31;i>=0;i--){
                int s=(x>>>i)&1;
                if(temp.children[s]==null)
                    temp.children[s]=new TrieNode();
                temp=temp.children[s];
            }
        }
    }
    public int findMaximumXOR2(int[] nums) {
        Trie t=new Trie();
        for(int i:nums){
            t.insert(i);
        }
        int max=0;
        for(int x:nums){
            int res=0;
            TrieNode temp=t.root;
            for(int i=31;i>=0;i--){
                int s=(x>>>i)&1;
                if(temp.children[0]!=null&&(s^0)==1){
                    res|=(0<<i);
                    temp=temp.children[0];
                }else if(temp.children[1]!=null&&(s^1)==1){
                    res|=(1<<i);
                    temp=temp.children[1];
                }else if(temp.children[0]==null){
                    res|=(1<<i);
                    temp=temp.children[1];
                }else if(temp.children[1]==null){
                    res|=(0<<i);
                    temp=temp.children[0];
                }
            }
            //System.out.print(res+" ");
            res^=x;
            max=Math.max(max,res);
        }
        //dfs(t.root);
        return max;
    }
}

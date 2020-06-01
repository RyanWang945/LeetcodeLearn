package 刷题.leetcode;

/**
 * @author Ryan
 * @date 2020/5/30 20:27
 */
public class _677 {
    class MapSum{
        Trie t;
        /** Initialize your data structure here. */
        public MapSum() {
            t=new Trie();
        }

        public void insert(String key, int val) {
            TrieNode temp=t.root;
            for(char c:key.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null)
                    temp.children[i]=new TrieNode();
                temp=temp.children[i];
            }
            temp.isEnd=true;
            temp.val=val;
        }

        public int sum(String prefix) {
            TrieNode temp=t.root;
            for(char c:prefix.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null)
                    return 0;
                else
                    temp=temp.children[i];
            }
            int[] count=new int[2];
            dfs(count,temp);
            return count[0];
        }
        private void dfs(int[] count,TrieNode temp){
            if(temp.isEnd==true){
                count[0]+=temp.val;
            }
            for(int i=0;i<26;i++){
                if(temp.children[i]!=null)
                    dfs(count,temp.children[i]);
            }
            return;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
    }
    class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
        int val=0;
        public TrieNode(){
            this.isEnd=false;
        }
    }

}

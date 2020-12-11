package 实验性测试;

/**
 * @author Ryan
 * @date 2020/8/3 15:53
 */
public class TrieTest {
    private class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
        public void insert(String s){
            TrieNode temp=root;
            for(char c:s.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null){
                    temp.children[i]=new TrieNode();
                }
                temp=temp.children[i];
            }
            temp.isEnd=true;
        }
        public boolean search(String s){
            TrieNode temp=root;
            for(char c:s.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null)
                    return false;
                else temp=temp.children[i];
            }
            return temp.isEnd;
        }
        public boolean startWith(String s){
            TrieNode temp=root;
            for(char c:s.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null)
                    return false;
                else temp=temp.children[i];
            }
            return true;
        }
    }
    private class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
        public TrieNode(){
            this.isEnd=false;
        }
    }
}

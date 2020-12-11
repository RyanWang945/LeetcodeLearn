package algorithmnote.字典树模板;

/**
 * @author Ryan
 * @date 2020/6/15 9:59
 */
public class Trie {
    private class TrieNode{
        boolean isEnd;
        TrieNode[] children=new TrieNode[26];
        public TrieNode(){
            this.isEnd=false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(temp.children[i]==null)
                temp.children[i]=new TrieNode();
            temp=temp.children[i];
        }
        temp.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c:word.toCharArray()){
            int i=c-'a';
            if(temp.children[i]==null)
                return false;
            temp=temp.children[i];
        }
        return temp.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c:prefix.toCharArray()){
            int i=c-'a';
            if(temp.children[i]==null)
                return false;
            temp=temp.children[i];
        }
        return true;
    }
}

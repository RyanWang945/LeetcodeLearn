package 刷题.leetcode;

import java.util.List;

/**
 * @author Ryan
 * @date 2020/5/15 21:56
 */
public class _648 {
    private class TrieNode{
        boolean is_end ;
        TrieNode[] children = new TrieNode[26] ;
        public TrieNode(){
            this.is_end = false ;
        }
    }
    private class Trie{
        TrieNode root ;
        public Trie(){
            root = new TrieNode() ;
        }
        public void insert(String s){
            TrieNode temp = root ;
            for(char c:s.toCharArray()){
                int i = c - 'a' ;
                if(temp.children[i] == null){
                    temp.children[i] = new TrieNode() ;
                }
                temp = temp.children[i] ;
            }
            temp.is_end = true ;
        }
        public String search(String s){
            TrieNode temp = root ;
            StringBuilder sb = new StringBuilder() ;
            for(char c:s.toCharArray()){
                int i = c - 'a' ;
                if(temp.children[i] == null){
                    return s ;
                }
                sb.append(c) ;
                temp = temp.children[i] ;
                if(temp.is_end){
                    return sb.toString() ;
                }
            }
            return s;//这种情况似乎是，dict中前缀的长度如果大于单词的长度时，就直接返回这个单词
        }
    }
    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder() ;
        Trie t = new Trie();
        for(String word:dict){
            t.insert(word);
        }
        String[] words = sentence.split(" ");
        for(String word:words){
            if(sb.length()>0) sb.append(" ");
            sb.append(t.search(word));
        }
        return sb.toString();
    }
}

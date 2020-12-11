package 刷题.牛客;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/8/3 16:11
 */
public class 最小唯一前缀 {
    private static List<String> list=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Trie t=new Trie();
        String[] strs=new String[n];
        for(int i=0;i<n;i++){
            String s=sc.next();
            sc.nextLine();
            t.insert(s);
            strs[i]=s;
        }
        for(String s:strs){
            list.add(t.search(s));
        }
        for(String s:list){
            System.out.println(s);
        }
    }
    private static class Trie{
        TrieNode root;
        public Trie(){
            this.root=new TrieNode();
        }
        public String search(String s){
            TrieNode temp=root;
            StringBuilder sb=new StringBuilder();
            for(char c:s.toCharArray()){
                int i=c-'a';
                sb.append((char)('a'+i));
                if(temp.children[i].count==1) {
                    return sb.toString();
                }
                temp=temp.children[i];
            }
            return s;
        }
        public void insert(String s){
            TrieNode temp=root;
            for(char c:s.toCharArray()){
                int i=c-'a';
                if(temp.children[i]==null)
                    temp.children[i]=new TrieNode();
                temp.children[i].count++;
                temp=temp.children[i];
            }
            temp.isEnd=true;
        }
    }
    private static class TrieNode{
        boolean isEnd;
        int count=0;
        TrieNode[] children=new TrieNode[26];
        public TrieNode(){
            isEnd=false;
        }
    }
}

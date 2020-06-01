package 实验性测试;

import java.util.Scanner;


/**
 * @author Ryan
 * @date 2020/5/28 9:52
 * 3
 * aba ababababababaaababababa
 */
public class Solution0528 {
    public static void main(String[] args) {
        int max = 0;
        String maxString = " ";
        class TrieNode{
            boolean isEnd;
            int num=0;
            TrieNode[] children=new TrieNode[100];
            public TrieNode(){
                this.isEnd=false;
            }
        }
        class Trie{
            TrieNode root;
            public Trie(){
                root=new TrieNode();
            }
            public int insert(String s){
                TrieNode temp=root;
                char[] chs=s.toCharArray();
                for(char c:chs){
                    int i=c-32;
                    if(temp.children[i]==null)
                        temp.children[i]=new TrieNode();
                    temp=temp.children[i];
                }
                temp.isEnd=true;
                temp.num++;
                return temp.num;
            }
        }
        Trie trie=new Trie();
        Scanner sc=new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String t=sc.nextLine();
        for(int i=0;i<=t.length()-len;i++){
            String s=t.substring(i,i+len);
            int time=trie.insert(s);
            if(time>max){
                max=time;
                maxString=s;
            }else if(time==max){
                if(s.compareTo(maxString)<0){
                    max=time;
                    maxString=s;
                }
            }
        }
        System.out.println(maxString+" "+max);
    }
}

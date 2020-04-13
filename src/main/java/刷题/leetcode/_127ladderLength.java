package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/3/8 17:31
 */
public class _127ladderLength {
    /**
     * 这个官方代码简直是nt，什么玩意写成这么一坨。
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        int count=0;
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            count++;
            int size=queue.size();
            for(int i=0;i<size;i++){
                String start=queue.poll();
                for(String s:wordList){
                    if(visited.contains(s))
                        continue;
                    if(!canConvert(s,start))
                        continue;
                    if(s.equals(endWord))
                        return count++;
                    visited.add(s);
                    queue.offer(s);
                }
            }
        }
        return 0;
    }
    private boolean canConvert(String a,String b){
        int count=0;
        int len=a.length();
        if(a.length()!=b.length())
            return false;
        for(int i=0;i<len;i++){
            if(a.charAt(i)!=b.charAt(i))
                count++;
            if(count>=2) return false;
        }
        return count==1;
    }

    /**
     * 双端BFS加状态转移
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int end=wordList.indexOf(endWord);
        if(end==-1)
            return 0;
        wordList.add(beginWord);
        Queue<String> queue1=new LinkedList<>();
        Queue<String> queue2=new LinkedList<>();
        Set<String> visited1=new HashSet<>();
        Set<String> visited2=new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);
        int count=0;
        Set<String> allWordSet=new HashSet<>(wordList);
        while(!queue1.isEmpty()&&!queue2.isEmpty()){
            count++;
            if(queue1.size()>queue2.size()){
                Queue<String> temp=queue1;
                queue1=queue2;
                queue2=temp;
                Set<String> t=visited1;
                visited1=visited2;
                visited2=t;
            }
            int size1=queue1.size();
            while(size1-->0){
                String s=queue1.poll();
                int n=s.length();
                char[] chars=s.toCharArray();
                for(int j=0;j<n;j++){
                    char c0=chars[j];
                    for(char c='a';c<='z';c++){
                        chars[j]=c;
                        String newString=new String(chars);
                        if(visited1.contains(newString)){
                            continue;
                        }
                        if(visited2.contains(newString))
                            return count+1;
                        if(allWordSet.contains(newString)){
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    chars[j]=c0;
                }
            }
        }
        return 0;
    }}

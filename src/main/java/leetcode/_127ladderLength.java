package leetcode;

import javafx.util.Pair;

import java.text.DecimalFormat;
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
        int len=beginWord.length();
        HashMap<String , ArrayList<String>> allComboDict=new HashMap<>();
        wordList.forEach(
                word->{
                    for(int i=0;i<len;i++){
                        String newWord=word.substring(0,i)+'*'+word.substring(i+1,len);
                        ArrayList<String> transformations=allComboDict.getOrDefault(newWord,new ArrayList<>());
                        transformations.add(word);
                        allComboDict.put(newWord,transformations);
                    }
                }
        );
        Queue<Pair<String,Integer>> queue=new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        HashMap<String,Boolean> visited=new HashMap<>();
        visited.put(beginWord,true);
        while(!queue.isEmpty()){
            Pair<String ,Integer> node=queue.remove();
            String word=node.getKey();
            int level=node.getValue();
            for(int i=0;i<len;i++){
                String newWord=word.substring(0,i)+'*'+word.substring(i+1,len);
                for(String adjacentWord:allComboDict.getOrDefault(newWord,new ArrayList<>())){
                    if(adjacentWord.equals(endWord))
                        return level+1;
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord,true);
                        queue.add(new Pair(adjacentWord,level+1));
                    }
                }
            }
        }
        return 0;
    }
    public int ladderLength2(String beginWord, String endWord, List<String> wordList){
        return 0;
    }
}

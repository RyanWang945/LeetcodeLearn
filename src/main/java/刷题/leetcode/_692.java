package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/5/30 19:46
 */
public class _692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        TreeMap<Integer,List<String>> treeMap=new TreeMap<>();
        for(String s:map.keySet()){
            if(treeMap.containsKey(map.get(s))){
                treeMap.get(map.get(s)).add(s);
                Collections.sort(treeMap.get(map.get(s)));
            }else{
                treeMap.put(map.get(s),new ArrayList<>());
                treeMap.get(map.get(s)).add(s);
            }


        }
        List<String> ans=new ArrayList<>();
        for(int i=k;i>0;){
            int a=treeMap.lastKey();
            //System.out.print(a+" ");
            if(treeMap.get(a).size()<=i){
                i-=treeMap.get(a).size();
                ans.addAll(treeMap.get(a));
                treeMap.remove(a);
            }else{
                List<String> temp=treeMap.get(a);
                for(int j=0;j<i;j++){
                    ans.add(temp.get(j));
                }
                break;
            }
        }
        return ans;
    }
}

package 刷题.leetcode;

import java.util.*;

/**
 * @author Ryan
 * @date 2020/6/1 12:13
 */
public class _332 {
    Map<String,List<String>> map=new HashMap<>();
    List<String> res=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String>ticket:tickets){
            if(!map.containsKey(ticket.get(0))){
                List<String> list=new LinkedList<>();
                list.add(ticket.get(1));
                map.put(ticket.get(0),list);
            }
            else{
                map.get(ticket.get(0)).add(ticket.get(1));
            }
        } // 建立图的邻接表

        for(List<String> list:map.values()){
            list.sort(String::compareTo);
        }

        dfs(map,"JFK");
        List<String> reverse=new ArrayList<>();
        for(int i=res.size()-1;i>=0;i--){
            reverse.add(res.get(i));
        }
        return reverse;

    }

    void dfs(Map<String,List<String>> map,String start){
        List<String> neighbors=map.get(start);
        while(neighbors!=null&&neighbors.size()>0){
            String dest=neighbors.get(0);
            neighbors.remove(0);
            dfs(map,dest);
        }
        res.add(start);
    }
}

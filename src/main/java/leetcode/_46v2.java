package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/1/2 17:52
 */
public class _46v2 {
    public List<List<Integer>> permute(int[] nums){
        int len=nums.length;
        List<List<Integer>> results=new ArrayList<>();
        if(len==0){
            return results;
        }
        boolean[] hashtable=new boolean[len];//用hashtable标记哪个元素被用了
        List<Integer> path=new ArrayList<>();//用path存储dfs的路径
        int depth=0;//用depth存储dfs的深度
        dfs(nums,len,depth,path,hashtable,results);
        return results;
    }
    private void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] hashtable,List<List<Integer>> results){
        if(depth==len){
            results.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(hashtable[i]==false){
                hashtable[i]=true;
                path.add(nums[i]);
                dfs(nums,len,depth+1,path,hashtable,results);
                hashtable[i]=true;
                path.remove(nums[i]);
            }
        }
    }
}

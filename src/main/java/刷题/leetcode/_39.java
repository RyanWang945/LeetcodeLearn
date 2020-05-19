package 刷题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/5/10 19:55
 */
public class _39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,temp,0,candidates,target,0);
        return res;
    }
    private void dfs(List<List<Integer>> res,List<Integer>tempList,int curr,int[] candidates,int target,int j){
        if(curr==target){
            res.add(new ArrayList<>(tempList));
            return;
        }
        for(int i=j;i<candidates.length;i++){
            if(curr+candidates[i]<=target){
                curr+=candidates[i];
                tempList.add(candidates[i]);
                dfs(res,tempList,curr,candidates,target,i);
                curr-=candidates[i];
                tempList.remove(tempList.size()-1);
            }else break;
        }
    }

}

package 刷题.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/5/10 20:50
 */
public class _78 {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        for(int i=1;i<=nums.length;i++){
            dfs(i,0,new ArrayList<>(),nums,0);
        }
        return ans;
    }
    private void dfs(int i,int curr,List<Integer> temp,int[] nums,int start){
        if(curr==i){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(curr<i){
            for(int x=start;x<nums.length;x++){
                temp.add(nums[x]);
                dfs(i,curr+1,temp,nums,x+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}

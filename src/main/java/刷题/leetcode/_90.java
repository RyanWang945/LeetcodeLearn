package 刷题.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ryan
 * @date 2020/5/11 10:06
 */
public class _90 {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<=nums.length;i++){
            dfs(nums,new ArrayList<>(),0,0,i);
        }
        res.add(new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums,List<Integer> temp,int index,int start,int n){
        if(index==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            dfs(nums,temp,index+1,i+1,n);
            temp.remove(temp.size()-1);
        }
    }
}
